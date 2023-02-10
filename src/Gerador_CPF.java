public class Gerador_CPF {
    // *-------------------------------------------------------- 
    // *Caso queia gerar um número de CPF aleatório, novo. **
    // *--------------------------------------------------------
    
        public static String criaCPF() {
            String parte01 = geraNumeroAleatorio();
            String parte02 = geraNumeroAleatorio();
            String parte03 = geraNumeroAleatorio();
            String cpfParcial = String.join(" ", parte01, parte02, parte03);
            System.out.println(cpfParcial);
            // criaDigito(cpfParcial);
            return null;
        }
    
        public static String geraNumeroAleatorio() {
            int num = (int) Math.floor(Math.random() * (999 - 1) + 1);
            String numString = Integer.toString(num);
            return num < 100 ? "0" + numString : numString;
        }
    
        // public static String[] criaDigito(String cpfParcial) {
        //     return cpfArray;
        // }
    
        public static void main(String[] args) {
            criaCPF();
    
        }
    }
    