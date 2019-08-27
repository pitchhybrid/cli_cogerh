package br.com.cogerh.template.enumeration;

public enum EnumStatusDiaria {
	
	AGUARDANDO_APROVA��O_NIVEL_1("1"), 
	AGUARDANDO_APROVA��O_NIVEL_2("2"), 
	AGUARDANDO_PRESTA�AO_DE_CONTAS("3"),
	DIARIA_REJEITADA("4"),
	ENCERRADA_N�O_REALIZADA("5"),
	ENCERRADA_REALIZADA("6");

	private String descricao;

	EnumStatusDiaria(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public static EnumStatusDiaria valueOf( final int ordinal )
	{
		final EnumStatusDiaria[] values = EnumStatusDiaria.values();

		for (final EnumStatusDiaria statusDiaria : values)
		{
			if (statusDiaria.ordinal() == ordinal)
				return statusDiaria;
		}

		return null;
	}
}
