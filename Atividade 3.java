import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        String jsonFilePath = "faturamento.json"; // Caminho para o arquivo JSON
        List<Double> faturamentos = lerFaturamentoJson(jsonFilePath);

        if (faturamentos.isEmpty()) {
            System.out.println("Nenhum dado de faturamento disponível.");
            return;
        }

        double menorFaturamento = faturamentos.stream().min(Double::compare).orElseThrow();
        double maiorFaturamento = faturamentos.stream().max(Double::compare).orElseThrow();
        double mediaMensal = faturamentos.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        long diasAcimaDaMedia = faturamentos.stream().filter(f -> f > mediaMensal).count();

        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    private static List<Double> lerFaturamentoJson(String filePath) {
        List<Double> faturamentos = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                double valor = item.getDouble("valor");
                if (valor > 0) { // Ignorar dias sem faturamento
                    faturamentos.add(valor);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return faturamentos;
    }
}
