package softex;

import java.io.FileOutputStream;
import java.io.IOException;

public class App{

    public static void limparTela(){
        try{
            new ProcessBuilder("cmd", "/c","cls").start
            ().waitFor();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

public static void main(String[] args) throws Exception {
    limparTela();
    //criarAqruivoBinarioSerializado();
    //lerArquivoBinarioSerializado();
    ArrayList<Pessoa> pessoas = criarListaDePessoasEmMemoria();
    peristirListaDePessoasEmArquivoBinario(pessoas);
}

private static void criarArquivoBinarioSerializado() {
    Pessoa p1 = new Pessoa(1, "Harry Potter", 2022, "123456");
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("arquivo.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo");
                }
            }
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
