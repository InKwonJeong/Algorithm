package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public int solution(String word, String[] pages) {
        HashMap<String, WebPage> map = new HashMap<>();
        for(int i = 0; i < pages.length; i++) {
            WebPage page = makePage(i, pages[i], word);
            map.put(page.url, page);
        }

        for(String url : map.keySet()) {
            WebPage page = map.get(url);
            double link_point = page.basic_point / page.links.size();
            for(String link : page.links) {
                WebPage link_page = map.get(link);
                if(link_page != null)
                    link_page.link_point += link_point;
            }
        }

        WebPage[] webPages = new WebPage[map.size()];
        map.values().toArray(webPages);
        Arrays.sort(webPages, (o1, o2) -> {
            double point1 = o1.basic_point + o1.link_point;
            double point2 = o2.basic_point + o2.link_point;
            if(point1 > point2) {
                return -1;
            } else if(point1 < point2) {
                return 1;
            } else {
                return Integer.compare(o1.index, o2.index);
            }
        });

        return webPages[0].index;
    }

    private WebPage makePage(int index, String page, String keyword) {
        WebPage webPage = new WebPage(index);

        String[] words = page.toLowerCase().split("[^a-z]");
        for(String word: words) {
            if (word.equals(keyword.toLowerCase()))
                webPage.basic_point++;
        }

        String[] lines = page.split("[<>]");
        System.out.println(Arrays.toString(lines));
        for(String line : lines) {
            if(line.contains("meta property=\"og:url\"")) {
                for(String w : line.split("\"")) {
                    if(w.contains("https://")) {
                        webPage.url = w;
                        break;
                    }
                }
            } else if(line.contains("a href")) {
                for(String w : line.split("\"")) {
                    if(w.contains("https://")) {
                        webPage.links.add(w);
                        break;
                    }
                }
            }
        }

        return webPage;
    }

    static class WebPage {
        String url;
        List<String> links;
        int index;
        double basic_point, link_point;

        public WebPage(int index) {
            this.index = index;
            links = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "WebPage{" +
                    "url='" + url + '\'' +
                    ", links=" + links +
                    ", index=" + index +
                    ", basic_point=" + basic_point +
                    ", link_point=" + link_point +
                    '}';
        }
    }
}
