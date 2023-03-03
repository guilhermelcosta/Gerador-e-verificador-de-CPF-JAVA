public class Gerador_CPF {
    // *--------------------------------------------------------
    // *Para gerar um número de CPF aleatório. **
    // *--------------------------------------------------------

    public static String criaCPF() {
        String parte01 = geraNumeroAleatorio();
        String parte02 = geraNumeroAleatorio();
        String parte03 = geraNumeroAleatorio();
        String cpfParcial = parte01 + parte02 + parte03;
        String digito01 = criaDigito(cpfParcial);
        String digito02 = criaDigito(cpfParcial + digito01);
        System.out.println(parte01 + "." + parte02 + "." + parte03 + "-" + digito01 + digito02);
        return String.format("%s.%s.%s-%s%s", parte01, parte02, parte03, digito01, digito02);
    }

    public static String geraNumeroAleatorio() {
        int num = (int) Math.floor(Math.random() * (999 - 1) + 1);
        String numString = Integer.toString(num);
        return num < 100 ? "0" + numString : numString;
    }

    public static String criaDigito(String CPFParcial) {
        char[] CPFArray = CPFParcial.toCharArray();
        int regressivo = CPFArray.length + 1;
        int total = 0;
        for (char num : CPFArray) {
            total += Character.getNumericValue(num) * regressivo--;
        }
        int digito = 11 - (total % 11);
        return (digito > 9) ? "0" : String.valueOf(digito);
    }

    // *--------------------------------------------------------
    // *Para verificar um número de CPF já existente.**
    // *--------------------------------------------------------

    static boolean validaCPF(String CPF) {
        CPF = CPF.replaceAll("[.-]", "");
        // if (CPF.length() != 11) return false;
        String cpfParcial = CPF.substring(0, 9);
        String digito01 = criaDigito(cpfParcial);
        String digito02 = criaDigito(cpfParcial + digito01);
        String novoCPF = cpfParcial + digito01 + digito02;
        return CPF.equals(novoCPF);
    }

    public static void main(String[] args) {

        // Para criar um novo número de CPF válido.
        criaCPF();

        // Para validar um número de CPF existente.
        String CPF = "123.123.123-00";
        System.out.println(validaCPF(CPF) ? CPF + " CPF válido!" : CPF + " CPF Inválido");
    }
}
