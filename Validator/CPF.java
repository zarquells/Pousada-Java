package Validator;

import javax.swing.JOptionPane;


public class CPF {
    private String cpf;
    private boolean teste;
    
 public CPF(String cpf, boolean teste){
        this.cpf = cpf;
        this.teste = teste;
    }
 
  public boolean getTeste(){
        return teste;
    }
    public String getCpf() {
        return cpf;
    }
 
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String validadorCPF(){
        this.cpf = this.cpf.replaceAll("[^0-9]", "");
	// Inicializando as variáveis que irão corresponder à cada caractere do cpf
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	int num4 = 0;
	int num5 = 0;
	int num6 = 0;
	int num7 = 0;
	int num8 = 0;
	int num9 = 0;
	int digito1 = 0;
	int digito2 = 0;
        // Vendo se o cpf tem 11 digitos e atribuindo os números digitados às váriaveis
        if (this.cpf.length() == 11) {
            num1 = Character.getNumericValue(this.cpf.charAt(0));
            num2 = Character.getNumericValue(this.cpf.charAt(1));
            num3 = Character.getNumericValue(this.cpf.charAt(2));
            num4 = Character.getNumericValue(this.cpf.charAt(3));
            num5 = Character.getNumericValue(this.cpf.charAt(4));
            num6 = Character.getNumericValue(this.cpf.charAt(5));
            num7 = Character.getNumericValue(this.cpf.charAt(6));
            num8 = Character.getNumericValue(this.cpf.charAt(7));
            num9 = Character.getNumericValue(this.cpf.charAt(8));
            digito1 = Character.getNumericValue(this.cpf.charAt(9));
            digito2 = Character.getNumericValue(this.cpf.charAt(10));
        } else {
            JOptionPane.showMessageDialog(null, "O CPF deve conter 11 números, sendo 2 deles os dois digitos verificadores");
        }
 
        // Soma para validar primeiro digito
        int somaDigito1 = (num1 * 10) + (num2 * 9) + (num3 * 8) + (num4 * 7) + (num5 * 6) + (num6 * 5) + (num7 * 4) + (num8 * 3) + (num9 * 2);
 
        // Divisão para validar primeiro digito
        double resultDigito1 = somaDigito1 * 10 % 11;
 
        // Soma para validar segundo digito
        int somaDigito2 = (num1 * 11) + (num2 * 10) + (num3 * 9) + (num4 * 8) + (num5 * 7) + (num6 * 6) + (num7 * 5) + (num8 * 4) + (num9 * 3) + (digito1 * 2);
 
        // Divisão para validar segundo digito
        double resultDigito2 = somaDigito2 * 10 % 11;
 
        // Convertendo o resto 10 para 0
        if (resultDigito1 == 10) {
            resultDigito1 = 0;
        }
 
        if (resultDigito2 == 10) {
            resultDigito2 = 0;
        }
 
        // Invalidando CPFs com números iguais
        String inv1 = "11111111111";
        String inv2 = "22222222222";
        String inv3 = "33333333333";
        String inv4 = "44444444444";
        String inv5 = "55555555555";
        String inv6 = "66666666666";
        String inv7 = "77777777777";
        String inv8 = "88888888888";
        String inv9 = "99999999999";
 
        if ((this.cpf.equals(inv1)) || (this.cpf.equals(inv2)) || (this.cpf.equals(inv3)) || (this.cpf.equals(inv4)) || (this.cpf.equals(inv5)) || (this.cpf.equals(inv6)) || (this.cpf.equals(inv7)) || (this.cpf.equals(inv8)) || (this.cpf.equals(inv9))) {
            JOptionPane.showMessageDialog(null, "O CPF informado é inválido");
            this.teste = false;
        } else if ((digito1 == resultDigito1) && (digito2 == resultDigito2) && (this.cpf.length() == 11)) {
            this.teste = true;
        } else {
            JOptionPane.showMessageDialog(null, "O CPF informado é inválido");
            this.teste = false;
        }
        return this.cpf;
    }
}
