// Classe Pessoa (Superclasse)
class Pessoa {
    protected String nome;
    protected int idade;
    protected String documento;

    public Pessoa(String nome, int idade, String documento) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
    }

    public void seApresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}

// Classe Piloto (Herda de Pessoa)
class Piloto extends Pessoa {
    private String licenca;
    private int horasVoo;

    public Piloto(String nome, int idade, String documento, String licenca, int horasVoo) {
        super(nome, idade, documento);
        this.licenca = licenca;
        this.horasVoo = horasVoo;
    }

    public void pilotar() {
        System.out.println(nome + " está pilotando a aeronave.");
    }
}

// Classe Passageiro (Herda de Pessoa)
class Passageiro extends Pessoa {
    private String bilhete;
    private String destino;

    public Passageiro(String nome, int idade, String documento, String bilhete, String destino) {
        super(nome, idade, documento);
        this.bilhete = bilhete;
        this.destino = destino;
    }

    public void embarcar() {
        System.out.println(nome + " embarcou no voo para " + destino);
    }
}

// Classe Aeronave
class Aeronave {
    private String modelo;
    private int capacidade;
    private String identificador;
    private Piloto piloto; // Dependência
    private Passageiro[] passageiros; // Associação

    public Aeronave(String modelo, int capacidade, String identificador, Piloto piloto, Passageiro[] passageiros) {
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.identificador = identificador;
        this.piloto = piloto;
        this.passageiros = passageiros;
    }

    public void decolar() {
        System.out.println("Aeronave " + identificador + " está decolando sob o comando de " + piloto.nome);
    }
}

// Classe Aeroporto
class Aeroporto {
    private String nome;
    private String codigo;
    private String cidade;

    public Aeroporto(String nome, String codigo, String cidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public void receberVoo(Aeronave aeronave) {
        System.out.println("Aeronave " + aeronave + " aterrissou no aeroporto " + nome);
    }
}
public class Teste {
    public static void main(String[] args) {
        // Criando Aeroportos
        Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internacional", "GRU", "São Paulo");
        Aeroporto aeroporto2 = new Aeroporto("Aeroporto Santos Dumont", "SDU", "Rio de Janeiro");

        // Criando Pilotos
        Piloto piloto1 = new Piloto("Carlos Silva", 45, "123456", "ATPL", 5000);
        Piloto piloto2 = new Piloto("Ana Souza", 38, "654321", "CPL", 3000);

        // Criando Passageiros
        Passageiro passageiro1 = new Passageiro("João Pereira", 30, "987654", "12345A", "São Paulo");
        Passageiro passageiro2 = new Passageiro("Maria Oliveira", 27, "567890", "67890B", "Rio de Janeiro");

        Passageiro[] passageirosVoo1 = { passageiro1, passageiro2 };

        // Criando Aeronaves
        Aeronave aeronave1 = new Aeronave("Boeing 737", 180, "BR123", piloto1, passageirosVoo1);
        Aeronave aeronave2 = new Aeronave("Airbus A320", 160, "BR456", piloto2, new Passageiro[] { passageiro1 });

        // Simulando eventos
        aeronave1.decolar();
        aeroporto2.receberVoo(aeronave1);

        aeronave2.decolar();
        aeroporto1.receberVoo(aeronave2);

        // Chamando métodos de apresentação
        piloto1.seApresentar();
        passageiro1.seApresentar();
    }
}
