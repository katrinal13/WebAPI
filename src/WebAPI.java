import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WebAPI
{
    public static void main (String[] args)
    {
        String APIkey = "ENTER API";
        String urlNowPlaying = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + APIkey + "&language=en-US";
        makeAPICall(urlNowPlaying);

        System.out.print("Which movie (enter ID)? ");
        Scanner s = new Scanner(System.in);
        String movieID = s.nextLine();

        String movieURL = "https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + APIkey + "&language=en-US";
        makeAPICall(movieURL);

        System.out.print("Which person (enter ID)? ");
        String personID = s.nextLine();

        String personURL = "https://api.themoviedb.org/3/person/" + personID + "?api_key=" + APIkey + "&language=en-US";
        makeAPICall(personURL);

    }

    public static void makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.headers());
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

