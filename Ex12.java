import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Aluno {
    private long id;
    private Date nascimento;
    private String ra;
    private String nome;

    public Aluno(long id, Date nascimento, String ra, String nome) {
        this.id = id;
        this.nascimento = nascimento;
        this.ra = ra;
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nRA: " + ra + "\nNascimento: " + nascimento;
    }
}

class GestaoAlunos {
    private int indice = 0;
    private Aluno[] alunos = new Aluno[50];
    private Scanner scan = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void criar() {
        if (indice >= 50) {
            System.out.println("Capacidade máxima de alunos atingida.");
            return;
        }

        System.out.print("Digite o ID: ");
        long id = scan.nextLong();
        scan.nextLine();

        System.out.print("Digite o RA: ");
        String ra = scan.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();

        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
        Date nascimento = null;
        try {
            nascimento = sdf.parse(scan.nextLine());
        } catch (ParseException e) {
            System.out.println("Formato de data inválido.");
            return;
        }

        alunos[indice++] = new Aluno(id, nascimento, ra, nome);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void exibir() {
        System.out.print("Digite o RA do aluno: ");
        String ra = scan.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getRa().equals(ra)) {
                System.out.println("\n=== Dados do Aluno ===\n" + aluno);
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    public void excluir() {
        System.out.print("Digite o RA do aluno a ser removido: ");
        String ra = scan.nextLine();

        for (int i = 0; i < indice; i++) {
            if (alunos[i] != null && alunos[i].getRa().equals(ra)) {
                System.out.println("Aluno " + alunos[i].getRa() + " removido.");
                alunos[i] = null;
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    public void atualizar() {
        System.out.print("Digite o RA do aluno a ser atualizado: ");
        String ra = scan.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getRa().equals(ra)) {
                System.out.print("Digite o novo nome: ");
                aluno.setNome(scan.nextLine());

                System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
                try {
                    aluno.setNascimento(sdf.parse(scan.nextLine()));
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido.");
                    return;
                }

                System.out.println("Dados atualizados com sucesso!");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("(C)riar  (E)xibir  (R)emover  (A)tualizar  (S)air");
            System.out.print("Escolha uma opção: ");

            String textoMaiusculo = scan.nextLine().toUpperCase();
            if (textoMaiusculo.isEmpty()) continue;

            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'C': criar(); break;
                case 'E': exibir(); break;
                case 'R': excluir(); break;
                case 'A': atualizar(); break;
                case 'S': System.out.println("Saindo do sistema..."); return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
}

public class Teste {
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.menu();
    }
}
