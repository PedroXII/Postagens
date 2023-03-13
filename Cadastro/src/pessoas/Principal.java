package pessoas;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		String nome, sexo = "", fim = "", comando = "";
		int idade, cpf;
		boolean existe;
		Pessoa person = new Pessoa();
		Scanner read = new Scanner(System.in);
		ArrayList <Pessoa> people = new ArrayList <Pessoa>();
		PessoaDAO pessoadao = new PessoaDAO();
		
		do{
			try {
				pessoadao.createTable();
				existe = false;
				System.out.println("======= Cadastro de Pessoas =======\n\n1 - Cadastrar uma pessoa.\n2 - Atualizar um cadastro.\n3 - Deletar um cadastro.\n4 - Consultar um cadastro específico.\n5 - Visualizar todos os cadastrados.\n6 - Sair do programa.\n\nComando: ");
				comando = read.nextLine();
				
				if(comando.equalsIgnoreCase("1")) {
					System.out.println("\nDigite o CPF da pessoa à ser cadastrado: ");
					cpf = read.nextInt();
					people = pessoadao.read();
					for(int i = 0; i < people.size(); i++) {
						if(people.get(i).getCpf() == cpf) {
							existe = true;
						}
					}
					if(existe == false) {
						System.out.println("Digite o nome da pessoa: ");
						nome = read.nextLine();
						nome = read.nextLine();
						System.out.println("Digite a idade da pessoa: ");
						idade = read.nextInt();
						boolean ok = false;
						do {
							System.out.println("Qual o sexo da pessoa?\n\n1 - Feminino.\n2 - Masculino.\n\nDigite:");
							comando = read.nextLine();
							comando = read.nextLine();
							if(comando.equalsIgnoreCase("1")) {
								sexo = "FEMININO";
								ok = true;
							}
							else if(comando.equalsIgnoreCase("2")) {
								sexo = "MASCULINO";
								ok = true;
							}
							else {
								System.out.println("Comando inválido!\nPressione [ENTER] para prosseguir.");
								comando = read.nextLine();
								comando = read.nextLine();
							}
						} while(ok == false);
						person.setCpf(cpf);
						person.setNome(nome);
						person.setIdade(idade);
						person.setSexo(sexo);
						pessoadao.create(person);
						System.out.println("Pessoa cadastrada com sucesso!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
					}
					else if (existe == true) {
						System.out.println("CPF já cadastrado!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
						comando = read.nextLine();
					}
				}
				
				else if(comando.equalsIgnoreCase("2")) {
					System.out.println("\nDigite o CPF da pessoa à ser atualizado: ");
					cpf = read.nextInt();
					people = pessoadao.read();
					for(int i = 0; i < people.size(); i++) {
						if(people.get(i).getCpf() == cpf) {
							existe = true;
						}
					}
					if(existe == false) {
						System.out.println("CPF não encontrado!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
						comando = read.nextLine();
					}
					else if (existe == true) {
						System.out.println("Digite o novo nome da pessoa: ");
						nome = read.nextLine();
						nome = read.nextLine();
						System.out.println("Digite a nova idade da pessoa: ");
						idade = read.nextInt();
						boolean ok = false;
						do {
							System.out.println("Qual o novo sexo da pessoa?\n\n1 - Feminino.\n2 - Masculino.\n\nDigite:");
							comando = read.nextLine();
							comando = read.nextLine();
							if(comando.equalsIgnoreCase("1")) {
								sexo = "FEMININO";
								ok = true;
							}
							else if(comando.equalsIgnoreCase("2")) {
								sexo = "MASCULINO";
								ok = true;
							}
							else {
								System.out.println("Comando inválido!\nPressione [ENTER] para prosseguir.");
								comando = read.nextLine();
								comando = read.nextLine();
							}
						} while(ok == false);
						person.setCpf(cpf);
						person.setNome(nome);
						person.setIdade(idade);
						person.setSexo(sexo);
						pessoadao.update(person);
						System.out.println("Cadastro atualizado com sucesso!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
					}
				}
				
				else if(comando.equalsIgnoreCase("3")) {
					System.out.println("\nDigite o CPF da pessoa à ser deletado: ");
					cpf = read.nextInt();
					people = pessoadao.read();
					for(int i = 0; i < people.size(); i++) {
						if(people.get(i).getCpf() == cpf) {
							existe = true;
							person.setCpf(people.get(i).getCpf());
							person.setNome(people.get(i).getNome());
							person.setIdade(people.get(i).getIdade());
							person.setSexo(people.get(i).getSexo());
						}
					}
					if(existe == false) {
						System.out.println("CPF não encontrado!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
						comando = read.nextLine();
					}
					else if (existe == true) {
						System.out.println("Tem certeza que quer deletar esta pessoa do cadastro?\n\nCPF: " + person.getCpf() + ", Nome: " + person.getNome() + ", Idade: " + person.getIdade() + ", Sexo: " + person.getSexo() + "\n\n1 - Deletar.\n2 - Não deletar.\n\nComando: ");
						comando = read.nextLine();
						comando = read.nextLine();
						if(comando.equalsIgnoreCase("1")) {
							pessoadao.delete(person);
							System.out.println("Cadastro deletado com sucesso!\nPressione [ENTER] para prosseguir.");
							comando = read.nextLine();
						}
						else if (comando.equalsIgnoreCase("2")) {
						}
					}
				}
				
				else if(comando.equalsIgnoreCase("4")) {
					System.out.println("\nDigite o CPF da pessoa à ser consultada: ");
					cpf = read.nextInt();
					people = pessoadao.read();
					for(int i = 0; i < people.size(); i++) {
						if(people.get(i).getCpf() == cpf) {
							existe = true;
							person.setCpf(people.get(i).getCpf());
							person.setNome(people.get(i).getNome());
							person.setIdade(people.get(i).getIdade());
							person.setSexo(people.get(i).getSexo());
						}
					}
					if(existe == false) {
						System.out.println("CPF não encontrado!\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
						comando = read.nextLine();
					}
					else if (existe == true) {
						System.out.println("======= Pessoa Cadastrada =======\n\nCPF: " + person.getCpf() + ", Nome: " + person.getNome() + ", Idade: " + person.getIdade() + ", Sexo: " + person.getSexo());
						System.out.println("\nPressione [ENTER] para prosseguir.");
						comando = read.nextLine();
						comando = read.nextLine();
					}
				}
				
				else if(comando.equalsIgnoreCase("5")) {
					System.out.println("======= Todas as Pessoas Cadastradas =======\n");
					people = pessoadao.read();
					for(int i = 0; i < people.size(); i++) {
						System.out.println("CPF: " + people.get(i).getCpf() + ", Nome: " + people.get(i).getNome() + ", Idade: " + people.get(i).getIdade() + ", Sexo: " + people.get(i).getSexo());
					}
					System.out.println("\nPressione [ENTER] para prosseguir.");
					comando = read.nextLine();
				}
				
				else if (comando.equalsIgnoreCase("6")) {
					System.out.println("Tem certeza que deseja sair do programa?\n\n1 - Sair.\n2 - Não sair.\n\nComando: ");
					comando = read.nextLine();
					if (comando.equalsIgnoreCase("1")) {
						fim = "1";
					}
					else if (comando.equalsIgnoreCase("2")) {	
					}
				}
			}
			catch(Exception a) {
				System.out.println("ERRO!\nVerifique se todos os dados foram inseridos corretamente e tente de novo.\nPressione [ENTER] para prosseguir.");
				comando = read.nextLine();
			}
		} while(!fim.equalsIgnoreCase("1"));
	}
}