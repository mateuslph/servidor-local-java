package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("-- Iniciando o Servidor --");
		ServerSocket servidor = new ServerSocket(12345);
		ExecutorService threadPull = Executors.newCachedThreadPool();
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo Cliente na porta: " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			threadPull.execute(distribuirTarefas);
		}

	}

}
