package br.com.orders.service;

import br.com.orders.entities.Order;
import br.com.orders.entities.OrderItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProofService {

    private static final String absolutePath = "/home/everton/Development/Projects/orders";

    public static void proof(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comprovantes.txt"))) {
            Path path = Paths.get(absolutePath);
            if (!Files.isDirectory(path)) {
                Files.createDirectory(path);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("**************************\n\n")
                    .append(order.toString())
                    .append("\n\n**************************");
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
