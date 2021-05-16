package SistemaDeAnuncios;

import java.text.SimpleDateFormat;
import java.util.Date;

class Anuncio {
	
	// Declarando variáveis privadas da classe.  
	private String nomeAnuncio, cliente;
	private Date dataInicio, dataTermino;
	private double invetimentoPorDia, totalInvestimento; 
	private int totalVisualizacao, totalCliques, totalCompartilhamento, totalDias, filtroDiaInicio, filtroDiaTermino, filtroMesInicio, filtroMesTermino, filtroAnoInicio, filtroAnoTermino, filtroDataInicio, filtroDataTermino, verificadorDataInicio, verificadorDataTermino;
	
	// Criando o construtor da classe. 
	public Anuncio(String nomeAnuncio, String cliente, Date inicio, Date termino, double investimentoPorDia) {
		
		// Declarando a classe de fomortamação de data.
		SimpleDateFormat simplificarData = new SimpleDateFormat("yyyyMMdd");
		
		// Atribuindo os valores digitados pelo usuário na variável do objeto da classe anúncio.
		this.nomeAnuncio = nomeAnuncio;
		this.cliente = cliente;
		this.dataInicio = inicio;
		this.dataTermino = termino;
		this.invetimentoPorDia = investimentoPorDia;
		
		// Formatando variável e convertendo para um número inteiro e atribuindo a variável do objeto. 
		this.verificadorDataInicio = Integer.parseInt(simplificarData.format(this.dataInicio));
		this.verificadorDataTermino = Integer.parseInt(simplificarData.format(this.dataTermino));
		
	}
	
	// Método para verificar se a data informada pelo usuário está dentro do intervalo de data do anúncio. 
	public boolean chamadaDoFiltro() {
		// Variável 
		boolean condicao = false;
		
		// Condição que verifica se a data informada pelo usuário está dentro do intervalo de data do anúncio
		if ( (this.filtroDataInicio >= this.verificadorDataInicio ) && ( this.filtroDataTermino  <= this.verificadorDataTermino ) ) {
			
			// Chamando método e atribuindo a variável do objeto. 
			this.totalDias = totalDeDias( this.filtroDiaInicio, this.filtroDiaTermino, this.filtroMesInicio, this.filtroMesTermino, this.filtroAnoInicio, this.filtroAnoTermino);
			
			// Chamando método.
			calculadouraTotal();
			
			// Atribuindo estado a variável. 
			condicao = true;
			
		}else {
			// Atribuindo estado a variável.
			condicao = false;
		}
		
		// retornando estado contido na variável.
		return condicao;
	}

	public void calculadouraTotal() {

		// Variaveis
		int quantidadeVisualizacao, clicPorPessoa, compartilhamentoRede, visualizacaoCompartilhamento, condicao = 0;

		// Constantes (Valores encontrado por meio de regra de 3)
		final double CLIENTEXVISUALIZACAO = 8.333, CLIQUEXCOMPATILHAMENTO = 6.666, VALORXPESSOAS = 0.0333;
		
		// Calculando a quantidade de visualizações inicial.
		quantidadeVisualizacao = (int) (this.invetimentoPorDia / VALORXPESSOAS);
		
		// Cálculos necessários para obtenção do total de visualizações
		this.totalVisualizacao = quantidadeVisualizacao;
		clicPorPessoa = (int) (quantidadeVisualizacao / CLIENTEXVISUALIZACAO);
		this.totalCliques = clicPorPessoa;
		compartilhamentoRede = (int) (clicPorPessoa / CLIQUEXCOMPATILHAMENTO);
		this.totalCompartilhamento = compartilhamentoRede;

		// Estrutura de repetição para controlar quantidade de vezes que pode haver
		// compartilhamento e somar ao total de visualizações.
		while (compartilhamentoRede > 0 && condicao < 3) {
			visualizacaoCompartilhamento = compartilhamentoRede * 40;
			this.totalVisualizacao = this.totalVisualizacao + visualizacaoCompartilhamento;
			clicPorPessoa = 0;
			compartilhamentoRede = 0;
			clicPorPessoa = (int) (visualizacaoCompartilhamento / CLIENTEXVISUALIZACAO);
			this.totalCliques = this.totalCliques + clicPorPessoa;
			compartilhamentoRede = (int) (clicPorPessoa / CLIQUEXCOMPATILHAMENTO);
			this.totalCompartilhamento = this.totalCompartilhamento + compartilhamentoRede;
			condicao++;
		}
		
		// Multiplicando todos os valores calculados pela quantidade de dias que houve a divulgação do anúncio.
		this.totalInvestimento = this.invetimentoPorDia * this.totalDias;
		this.totalVisualizacao = this.totalVisualizacao * this.totalDias;
		this.totalCliques = this.totalCliques * this.totalDias;
		this.totalCompartilhamento = this.totalCompartilhamento * this.totalDias;
		
	}
	
	// Método para calcular o total de dias a partir de 2 datas
	public int totalDeDias(int diaInicial, int diaTermino, int mesInicio, int mesTermino, int anoInicio, int anoTermino) {
		int totalDias = 0, condicao1 = 0;
		
		// condição de verificação 
		if (anoInicio != anoTermino) {
			
			for (int i = mesInicio + 1; i <= 12; i++ ) {
				totalDias += identificadorDeDias(i, anoInicio);
			}
			
			for(int j = 1; j < mesTermino; j++) {
				totalDias += identificadorDeDias(j, anoInicio);
			}
			
			totalDias += ( ((identificadorDeDias(mesInicio, anoInicio) - diaInicial) + 1) + diaTermino );
			
		}
		
		// condição de verificação 
		else if(anoInicio == anoTermino) {
			
			// Estrutura condicional de repetição para somar quantidade de dias de cada mês. 
			for (int i = (mesInicio + 1); i <= (mesTermino - 1); i++ ) {
				totalDias += identificadorDeDias(i, anoInicio);
				condicao1 = 1;
				}
			
			// condição de verificação 
			if ( (diaInicial == diaTermino) && (mesInicio == mesTermino) ) {
				
				return totalDias += 1;
				
			}
			
			// condição de verificação 
			else if (diaInicial != diaTermino && mesInicio == mesTermino) {
				
				totalDias += ((diaTermino - diaInicial) + 1);
		
			}
			
			// condição de verificação 
			else if( (mesTermino - mesInicio == 1) || condicao1 != 0) {
				
				totalDias += ( ((identificadorDeDias(mesInicio, anoInicio) - diaInicial) + 1) + diaTermino );
				
			}
			
			// condição de verificação 
			else if (anoTermino - anoInicio > 1) {
				
				// Estrutura condicional de repetição para somar quantidade de dias de cada ano.
				for(int contador1 = anoInicio + 1; contador1 < anoTermino; contador1++) {
					
					// Estrutura condicional de repetição para somar quantidade de dias de cada mês.
					for (int contador2 = 1; contador2 <= 12; contador2++ ) {
						
						totalDias += identificadorDeDias(contador2, contador2);
						
					}
					
				}	
				
			}
		}
		
		// Retorna variável.
		return totalDias;
		
	}
	
	// Método para saber a quantidade de dias tem no mês
	public int identificadorDeDias(int mes, int ano) {
		int quantidadeDeDias = 0;
		
		// Condição para verificar quantidade de dias do mês. 
		switch (mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			quantidadeDeDias = 31;
			break;
		case 4: case 6: case 9: case 11:
			quantidadeDeDias = 30;
			break;
		case 2:
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
				quantidadeDeDias = 29;
				break;
			}else {
				quantidadeDeDias = 28;
				break;
			}	
		}
		
		// Retorna a quantidade total do determinado mês.
		return quantidadeDeDias;
	}
	
	// Método para atribuir valores às variáveis privadas do objeto. 
	public void setVariaveisFiltro(int DiaInicio, int DiaTermino, int MesInicio, int MesTermino, int AnoInicio, int AnoTermino, Date dataI, Date dataT) {
		
		// Atribuindo valores às variáveis.
		this.filtroDiaInicio = DiaInicio;
		this.filtroDiaTermino = DiaTermino;
		this.filtroMesInicio = MesInicio;
		this.filtroMesTermino = MesTermino;
		this.filtroAnoInicio = AnoInicio;
		this.filtroAnoTermino =	AnoTermino;
		
		// Declarando classe para formatação de data
		SimpleDateFormat simplificarData= new SimpleDateFormat("yyyyMMdd");
		
		// Formatando data e convertendo em número inteiro. 
		this.filtroDataInicio = Integer.parseInt(simplificarData.format(dataI));
		this.filtroDataTermino = Integer.parseInt(simplificarData.format(dataT));

	}
	
	// Métodos para modificar ou buscar variáveis privadas do objeto.
	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getNomeAnuncio() {
		return this.nomeAnuncio;
	}

	public double getTotalInvestimento() {
		return this.totalInvestimento;
	}


	public int getTotalVisualizacao() {
		return this.totalVisualizacao;
	}


	public int getTotalCliques() {
		return this.totalCliques;
	}


	public int getTotalCompartilhamento() {
		return this.totalCompartilhamento;
	}

	
}
