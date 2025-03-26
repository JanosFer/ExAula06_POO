import java.util.Scanner;

class Dinossauro {
    private int energia;
    private int velocidade;
    private int temperatura;
    private String humor;

    public Dinossauro() {
        this.energia = 50;
        this.velocidade = 10;
        this.temperatura = 25;
        this.humor = "Neutro";
    }

    public void pular() {
        if (energia >= 5 && velocidade >= 3) {
            energia -= 5;
            velocidade -= 3;
            humor = "Feliz";
            System.out.println("Skeep pulou!");
        } else {
            System.out.println("Skeep está cansado ou sem velocidade para pular.");
        }
    }

    public void correr() {
        if (energia >= 10 && velocidade >= 5) {
            energia -= 10;
            velocidade -= 5;
            humor = "Feliz";
            System.out.println("Skeep correu!");
        } else {
            System.out.println("Skeep está muito cansado para correr.");
        }
    }

    public void comer() {
        energia += 15;
        velocidade -= 2;
        humor = "Feliz";
        System.out.println("Skeep comeu e está cheio!");
    }

    public void cantar() {
        if (energia >= 5) {
            energia -= 5;
            humor = "Feliz";
            System.out.println("Skeep está cantando alegremente!");
        } else {
            System.out.println("Skeep está sem energia para cantar.");
        }
    }

    public void tomarSol() {
        velocidade += 5;
        temperatura += 5;
        humor = "Feliz";
        System.out.println("Skeep tomou sol e está mais rápido e aquecido!");
    }

    public void ficarNaSombra() {
        energia += 10;
        temperatura -= 5;
        humor = "Triste";
        System.out.println("Skeep descansou na sombra, mas ficou triste.");
    }

    public void mostrarStatus() {
        System.out.println("\n=== Status do Skeep ===");
        System.out.println("Energia: " + energia);
        System.out.println("Velocidade: " + velocidade);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Humor: " + humor);
        System.out.println("=======================");
    }
}

public class Teste {
    public static void main(String[] args) {
        Dinossauro skeep = new Dinossauro();
        Scanner scan = new Scanner(System.in);

        while (true) {
            skeep.mostrarStatus();

            System.out.println("\nEscolha uma ação:");
            System.out.println("(P)ular    (C)orrer    Co(M)er");
            System.out.println("C(A)ntar   Tomar (S)ol   Ficar na S(O)mbra");
            System.out.print("Opção: ");

            String textoMaiusculo = scan.nextLine().toUpperCase();
            if (textoMaiusculo.isEmpty()) continue; 
            
            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'P': skeep.pular(); break;
                case 'C': skeep.correr(); break;
                case 'M': skeep.comer(); break;
                case 'A': skeep.cantar(); break;
                case 'S': skeep.tomarSol(); break;
                case 'O': skeep.ficarNaSombra(); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }
}
