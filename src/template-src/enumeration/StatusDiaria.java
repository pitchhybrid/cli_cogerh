package br.com.cogerh.template.enumeration;

public enum StatusDiaria {

	/**
	 * Diária aguardando aprovação nível 01.
	 */
	AGUARDANDO_APROVACAO_NIVEL_1(1, "Diária aguardando aprovação nível 01"),

	/**
	 * Diária aguardando aprovação nível 02.
	 */
	AGUARDANDO_APROVACAO_NIVEL_2(2, "Diária aguardando aprovação nível 02"),

	/**
	 * Diária aguardando prestações de contas.
	 */
	AGUARDANDO_PRESTACAO_CONTAS(3, "Diária aguardando prestações de contas"),

	/**
	 * Diária rejeitada.
	 */
	DIARIA_REJEITADA(4, "Diária rejeitada"),
	
	/**
	 * Diária encerrada não realizada.
	 */
	ENCERRADA_NAO_REALIZADA(5, "Diária encerrada não realizada"),
	
	/**
	 * Diária encerrada e realizada.
	 */
	ENCERRADA_REALIZADA(6, "Diária encerrada e realizada");


	/**
	 * Valor (Ordinal) da enumeração.
	 */
	private Integer id;

	/**
	 * Descrição (String) da enumeração.
	 */
	private String descricao;

	/**
	 * Construtor da enumeração.
	 * 
	 * @param id
	 *            the id to set
	 */
	private StatusDiaria(final Integer id) {
		this.id = id;
	}

	/**
	 * Construtor da enumeração.
	 * 
	 * @param id
	 *            the id to set
	 * @param descricao
	 *            the descricao to set
	 */
	private StatusDiaria(final Integer id, final String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * @return Recuperando o campo descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return Recuperando o campo id
	 */
	public Integer getId() {
		return id;
	}

}

