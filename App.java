import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        //
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // principais dados (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001b[37;1m \u001b[44;1m" + "Titulo: " + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            double stars = Double
                    .parseDouble(
                            "\u011b[37;1m \u011b[44;1m" + "Nota do publico:" + filme.get("imDbRating") + "\u001b[m");
            int numeroInt = (int) stars;
            for (int i = 0; i < numeroInt; i++) {
                System.out.print("\uD83D\uDC99 👌");
            }
            System.out.println();

        }

    }
}
