package programmers.kakao;

import java.util.*;

public class MatchingScore {
    public static void main(String[] args) {
        String[] words = {"blind", "Muzi"};
        String[][] pages = {
                {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"},
                {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}
        };
        for(int i = 0; i < words.length; i++) {
            System.out.println(new MatchingScore().solution(words[i], pages[i]));
        }
    }

    private HashMap<String, Page> page_map;
    private String[] pages;
    private String word;

    public int solution(String word, String[] pages) {
        this.word = word.toLowerCase();
        this.pages = pages;
        page_map = new HashMap<>();

        for(int i = 0; i < pages.length; i++) {
            makePage(pages[i], i);
        }

        List<Page> page_list = new ArrayList<>();

        for(String url : page_map.keySet()) {
            Page page = page_map.get(url);
            plusLinkScore(page);
            page_list.add(page);
        }

        page_list.sort((o1, o2) -> {
            if(o1.getMatchScore() > o2.getMatchScore())
                return -1;
            else if(o1.getMatchScore() < o2.getMatchScore())
                return 1;
            else {
                return Integer.compare(o1.index, o2.index);
            }
        });

        return page_list.get(0).index;
    }

    private void plusLinkScore(Page page) {
        List<String> links = page.links;
        for(String link : links) {
            Page link_page = page_map.get(link);
            if(link_page != null)
                link_page.link_score += (page.basic_score / page.links.size());
        }
    }

    private float getBasicScore(Page page) {
        float score = 0;
        String html = pages[page.index].replaceAll("[^a-zA-Z]", " ");
        String[] words = html.split(" ");
        for(String word : words) {
            if(this.word.equals(word.toLowerCase()))
                score++;
        }
        return score;
    }

    private void makePage(String page, int index) {
        String[] words = page.split("[<>]");
        String url = "";
        List<String> url_list = new ArrayList<>();
        for (String word : words) {
            if (word.contains("meta property=\"og:url\"")) {
                url = word.split("\"")[3];
            } else if (word.contains("a href=")) {
                url_list.add(word.split("\"")[1]);
            }
        }

        Page p = new Page(index, url);
        p.links = url_list;
        p.basic_score = getBasicScore(p);
        page_map.put(p.url, p);
    }

    static class Page {
        String url;
        int index;
        float basic_score, link_score;
        List<String> links;

        Page(int index, String url) {
            this.index = index;
            this.url = url;
        }

        float getMatchScore() {
            return basic_score + link_score;
        }
    }
}
