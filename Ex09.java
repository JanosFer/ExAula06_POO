import java.util.ArrayList;
import java.util.List;

class Livro {
    private String titulo;

    public Livro() {
        this.titulo = "Livro Desconhecido";
    }

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Seção {
    private String nome;

    public Seção() {
        this.nome = "Seção Padrão";
    }

    public Seção(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Biblioteca {
    private List<Livro> livros;
    private Seção seção;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.seção = new Seção();
    }

    public Biblioteca(List<Livro> livros, Seção seção) {
        this.livros = livros;
        this.seção = seção;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void mostrarLivros() {
        for (Livro livro : livros) {
            System.out.println("Livro: " + livro.getTitulo());
        }
    }
}

class Cliente {
    private String nome;

    public Cliente() {
        this.nome = "Cliente Desconhecido";
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Cardápio {
    private String pratos;

    public Cardápio() {
        this.pratos = "Cardápio Padrão";
    }

    public Cardápio(String pratos) {
        this.pratos = pratos;
    }

    public String getPratos() {
        return pratos;
    }
}

class Restaurante {
    private List<Cliente> clientes;
    private Cardápio cardápio;

    public Restaurante() {
        this.clientes = new ArrayList<>();
        this.cardápio = new Cardápio();
    }

    public Restaurante(List<Cliente> clientes, Cardápio cardápio) {
        this.clientes = clientes;
        this.cardápio = cardápio;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome());
        }
    }
}

class Professor {
    private String nome;

    public Professor() {
        this.nome = "Professor Desconhecido";
    }

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Diretor {
    private String nome;

    public Diretor() {
        this.nome = "Diretor Desconhecido";
    }

    public Diretor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Escola {
    private List<Professor> professores;
    private Diretor diretor;

    public Escola() {
        this.professores = new ArrayList<>();
        this.diretor = new Diretor();
    }

    public Escola(List<Professor> professores, Diretor diretor) {
        this.professores = professores;
        this.diretor = diretor;
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void mostrarProfessores() {
        for (Professor professor : professores) {
            System.out.println("Professor: " + professor.getNome());
        }
    }
}

public class Teste {
    public static void main(String[] args) {
        // Criando livros
        Livro livro1 = new Livro("1984");
        Livro livro2 = new Livro("O Senhor dos Anéis");

        // Criando seção
        Seção seção = new Seção("Ficção");

        // Criando biblioteca e adicionando livros
        Biblioteca biblioteca = new Biblioteca(new ArrayList<>(), seção);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.mostrarLivros();

        System.out.println("----------------------");

        // Criando clientes
        Cliente cliente1 = new Cliente("Ana");
        Cliente cliente2 = new Cliente("Carlos");

        // Criando cardápio
        Cardápio cardápio = new Cardápio("Pizza, Hambúrguer, Salada");

        // Criando restaurante e adicionando clientes
        Restaurante restaurante = new Restaurante(new ArrayList<>(), cardápio);
        restaurante.adicionarCliente(cliente1);
        restaurante.adicionarCliente(cliente2);
        restaurante.mostrarClientes();

        System.out.println("----------------------");

        // Criando professores
        Professor professor1 = new Professor("João");
        Professor professor2 = new Professor("Maria");

        // Criando diretor
        Diretor diretor = new Diretor("Sr. Fernando");

        // Criando escola e adicionando professores
        Escola escola = new Escola(new ArrayList<>(), diretor);
        escola.adicionarProfessor(professor1);
        escola.adicionarProfessor(professor2);
        escola.mostrarProfessores();
    }
}
