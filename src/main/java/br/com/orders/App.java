package br.com.orders;

import br.com.orders.entities.Client;
import br.com.orders.entities.Order;
import br.com.orders.entities.OrderItem;
import br.com.orders.entities.Product;
import br.com.orders.entities.enuns.OrderStatus;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat dtB = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Nome cliente ");
        String name = in.nextLine();
        System.out.print("Email cliente ");
        String email = in.nextLine();
        System.out.print("Data de nascimento ");
        Date dtn = dtB.parse(in.nextLine());
        Client client = new Client(name,email,dtn);

        System.out.println("Dados do pedido");
        System.out.println("Status do pedido");
        OrderStatus status = OrderStatus.valueOf(in.next());
        Order order = new Order(new Date(),status,client);

        System.out.println("Quantidade de produtos para o pedido: ");
        int qtd = in.nextInt();
        for(int x =0 ; x < qtd; x++){
            System.out.printf("Nome do produto ");
            in.nextLine();
            String nameProduct = in.nextLine();
            System.out.printf("Valor : ");
            BigDecimal valueProduct = in.nextBigDecimal();
            Product product = new Product(nameProduct,valueProduct);
            System.out.printf("Quantidade :");
            int quantity = in.nextInt();
            OrderItem item = new OrderItem(quantity,product);
            order.addItem(item);
        }

        System.out.println(order);

    }
}