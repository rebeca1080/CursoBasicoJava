import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarefa> tarefas = new ArrayList<>();
        boolean executando = true;

        System.out.println("=== ToDo List ===");

        while (executando) {
            System.out.println("===== Menu =====");
            System.out.println("1- Cadastrar tarefa");
            System.out.println("2- Listar tarefas pendentes");
            System.out.println("3- Buscar tarefa por título");
            System.out.println("4- Marcar tarefa como concluída");
            System.out.println("5- Remover tarefa");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o título:");
                    String titulo = sc.nextLine();
                    System.out.println("Digite a descrição:");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a data de entrega (yyyy-MM-dd):");
                    LocalDate dataEntrega = LocalDate.parse(sc.nextLine());

                    Tarefa novaTarefa = new Tarefa(titulo, descricao, dataEntrega);
                    tarefas.add(novaTarefa);
                    System.out.println("✅ Tarefa cadastrada com sucesso!");
                }

                case 2 -> {
                    System.out.println("Tarefas pendentes:");
                    boolean encontrou = false;
                    for (Tarefa t : tarefas) {
                        if (!t.isConcluida()) {
                            System.out.println(t);
                            encontrou = true;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Nenhuma tarefa pendente.");
                    }
                }

                case 3 -> {
                    System.out.println("Digite o título para buscar:");
                    String busca = sc.nextLine();
                    boolean achou = false;
                    for (Tarefa t : tarefas) {
                        if (t.getTitulo().equalsIgnoreCase(busca)) {
                            System.out.println(t);
                            achou = true;
                        }
                    }
                    if (!achou) System.out.println("Nenhuma tarefa encontrada com esse título.");
                }

                case 4 -> {
                    System.out.println("Digite o título da tarefa a marcar como concluída:");
                    String titulo = sc.nextLine();
                    boolean encontrada = false;
                    for (Tarefa t : tarefas) {
                        if (t.getTitulo().equalsIgnoreCase(titulo)) {
                            t.setConcluida(true);
                            System.out.println("✅ Tarefa marcada como concluída!");
                            encontrada = true;
                        }
                    }
                    if (!encontrada) System.out.println("Tarefa não encontrada.");
                }

                case 5 -> {
                    System.out.println("Digite o título da tarefa a remover:");
                    String titulo = sc.nextLine();
                    boolean removida = tarefas.removeIf(t -> t.getTitulo().equalsIgnoreCase(titulo));
                    if (removida) System.out.println("🗑️ Tarefa removida!");
                    else System.out.println("Tarefa não encontrada.");
                }

                case 0 -> {
                    executando = false;
                    System.out.println("Saindo...");
                }

                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
