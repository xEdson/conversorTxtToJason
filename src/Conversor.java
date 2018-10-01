import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Message;
import modelo.MessageJason;

public class Conversor {

  public static void main(String[] args) {
    String codigo;
    String descricao;
    Integer count = 0;
    String nomeArquivo = "nome.json";
    Message messages[] = new Message[200];
    MessageJason messageJasons[] = new MessageJason[200];
    Integer posFim;
    try {

      FileReader fr = new FileReader("exemplo.txt");
      BufferedReader br = new BufferedReader(fr);
      ArrayList<String> linhas = new ArrayList<>();
      String linha = "";

      while ((linha = br.readLine()) != null) {
        codigo = linha.substring(0, (linha.indexOf("=")));
        descricao = linha.substring((linha.indexOf("=")) + 1, linha.length());
        messages[count] = new Message(codigo, descricao);
        linhas.add(linha);
        count++;
      }
      System.out.println(linhas.size());
      for (int i = 0; i < count; i++) {
        posFim = messages[i].getCodigo().length();
        if (messages[i].getCodigo().indexOf(".") > 0) {
          posFim = messages[i].getCodigo().indexOf(".");
        }
        messageJasons[i] = new MessageJason(messages[i].getCodigo(), messages[i].getCodigo(),
            messages[i].getCodigo().substring(0, posFim), messages[i].getDescricao());
      }
      BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));
      buffWrite.append("[");
      for (int i = 0; i < count; i++) {
        buffWrite.append("{");
        buffWrite.append("\"" + messageJasons[i].getCodAnterior() + "\":{");
        buffWrite.append("\"code\": \"" + messageJasons[i].getCodAual() + "\",");
        buffWrite.append("\"httpStatus\": \"" + messageJasons[i].getHttpCode() + "\",");
        buffWrite.append("\"description\": \"" + messageJasons[i].getDescricao() + "\"");
        if (i < count - 1) {
          buffWrite.append("}},");
        } else {
          buffWrite.append("}}");
        }
      }
      buffWrite.append("]");
      buffWrite.close();
      br.close();
      fr.close();


    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }

  }

}


