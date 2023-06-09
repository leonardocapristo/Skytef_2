package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import products.ImportedProduct;
import products.Product;
import products.UsedProduct;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> lista = new ArrayList<>();

        try {
            System.out.println("Digite o número de produtos: ");
            Integer numberProducts = sc.nextInt();

            for (int i = 1; i <= numberProducts; i++) {
                System.out.println("novo, usado ou importado (n/u/i)? ");

                char tipo = sc.next().charAt(0);

                System.out.println("Nome:");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.println("Preço:");
                double preco = sc.nextDouble();

                if (tipo == 'n') {
                    lista.add(new Product(nome, preco));

                } else if (tipo == 'u') {
                    System.out.println("Data : ");
                    sc.nextLine();
                    String data = sc.nextLine();
                    lista.add(new UsedProduct(nome, preco, data));

                } else {
                    System.out.println("Taxa da alfândega");
                    Double customsFee = sc.nextDouble();
                    lista.add(new ImportedProduct(nome, preco, customsFee));
                }
            }

            System.out.println();
            System.out.println("Etiqueta de produto:");
            for (Product prod : lista) {
                System.out.println(prod.priceTag());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do programa: " + e.getMessage());
            System.out.println("Dados inseridos incorretamente");
        } finally {
            sc.close();
        }
    }
}