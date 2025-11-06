package model.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Util {

    public static String formatarDataHora(LocalDateTime data) {
        if (data == null) {
            return "Sem data definida";
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return data.format(fmt);
    }

    public static boolean validaAno(int ano) {
        if (ano >= 1885 && ano <= 2026) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Data inválida! Informe data [1985 - 2026]");
            return false;
        }
    }

    public static boolean validaCPF(String cpf){
        
        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        
        soma += digito1 * 2;
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
    }

    public static boolean validaPlaca(String placa) {

        String regexAntiga = "^[A-Za-z]{3}\\d{4}$";
        String regexMercosul = "^[A-Za-z]{3}\\d[A-Za-z]\\d{2}$";

        if (placa.matches(regexAntiga) || placa.matches(regexMercosul)) {
            return true;
        } else {
            return false;
        }

    }

}
