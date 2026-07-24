# FitaEspelhoGenerator
Aplicação de apoio para geração dos dados para fita-espelho SIAPE.
Neste documento consta a descrição da geração do arquivo de importação de servidores e unidades.

## Compilação
Para compilar o projeto executar o seguinte comando na raiz do projeto: 

	javac -d bin $(find src -name "*.java")

Para rodar a aplicação executar o seguinte comando na raiz do projeto: 

	java -cp bin view.Index

OBS: O projeto foi desenvolvido na versão: **17** do Java, mas é provável que o mesmo possa ser executado em versões mais antigas.


## Preparação para criação das unidades
O banco de referência disponibilizado pela UFRN já possui uma unidade com código = 1100 que deverá ser atualizado para a unidade raiz da instituição. Esta unidade possui o nome fictício: **Cooperação Técnica.**

Neste ponto, o seguinte script realizar esta atualização:

**UPDATE comum.unidade set nome = 'UNIVERSIDADE TESTE', nome_ascii = 'UNIVERSIDADE TESTE', nome_capa = 'UNIVERSIDADE TESTE', sigla = 'UNITESTE', codigo_siapecad = 1;**

Este script deverá ser executado junto aos bancos: administrativo, sistemas_comum e sigaa.

## Montagem do arquivo de unidades.
Substituir o arquivo unidades.txt do diretório /arquivo_entrada presente na raiz do projeto.

O arquivo: **unidades.txt** deverá ter as seguintes informações das unidades, separados por ponto e vírgula (;) na seguinte ORDEM:

- Identificador da unidade; (Valor numérico de até 6 dígitos) - OBS: O código de id = 1 deverá ser reservado à unidade raiz. Neste caso não deverão existir unidades neste arquivo com este identificador = 1 (A unidade raiz já está presente no banco conforme procedimento descrito na seção anterior).
- Nome Completo da unidade; (Valor alfanumérico de até 40 dígitos)
- Sigla da unidade; (Valor alfanumérico de até 10 dígitos)
- Unidade Federativa (UF) da unidade; (Valor alfanumérico de até 2 dígitos)
- Unidade Responsável; (Valor numérico de até 6 dígitos) - OBS: Inserir o identificador da unidade responsável (unidade-pai) junto a este campo. Esta unidade deverá estar também mapeada nesta arquivo. Caso a unidade esteja diretamente ligada a unidade-raiz da instituição atribuir neste campo o valor = 1.

Ao executar a aplicação, junto a classe: Index.java deve-se selecionar a opção: 2 - Gerar Fita Espelho UNIDADES.

Por fim, será gerado um arquivo de saída dentro do diretório: arquivo_saida, denominado: fita_espelho_unidades.txt.

## Importando o arquivo de unidades no SIGRH
Após geração do arquivo de unidades, realizar a importação do arquivo junto ao sistema através da operação presente em: **SIGRH -> Módulo: Administração de Pessoal -> Aba: Administração -> Fita-Espelho -> Arquivo-Espelho SIAPE -> Unidade -> Processar Arquivo Unidade.**

Observar que antes de rodar o processamento do arquivo, deve-se executar o seguinte comando nos bancos: sistemas_comum e sigaa para evitar problemas no processamento:

**ALTER TABLE comum.unidade DROP CONSTRAINT fk_responsavel_organizacional;** 

**ALTER TABLE comum.unidade DROP CONSTRAINT unidade_id_gestora_academica_fkey;**

**ALTER TABLE comum.unidade DROP CONSTRAINT unidade_id_gestora_fkey;**

**ALTER TABLE comum.unidade DROP CONSTRAINT unidade_unidade_responsavel_fkey;**

Na tela apresentada pelo sistema informar:

**SIAPECAD:** Código SIAPECAD da unidade raiz, valor = 1;

**Arquivo de unidades:** Arquivo gerado no processo descrito na seção anterior.

**Arquivo de referência:** Arquivo de denominação: **UNIDADES.Ref** presente no diretório: arquivo_entrada deste projeto.

**Refazer os códigos das unidades:** Deixar esta opção selecionada/marcada.

Após finalização do procedimento, as unidades serão criadas, junto de sua hierarquia junto aos bancos: administrativo, sistemas_comum e sigaa.

Por fim reativar as constraints removidas no início do procedimento junto aos bancos: sistemas_comum e sigaa:

**ALTER TABLE comum.unidade ADD CONSTRAINT fk_responsavel_organizacional FOREIGN KEY (id_unid_resp_org) REFERENCES comum.unidade(id_unidade);**

**ALTER TABLE comum.unidade ADD CONSTRAINT unidade_id_gestora_academica_fkey FOREIGN KEY (id_gestora_academica) REFERENCES comum.unidade(id_unidade);**

**ALTER TABLE comum.unidade ADD CONSTRAINT unidade_id_gestora_fkey FOREIGN KEY (id_gestora) REFERENCES comum.unidade(id_unidade);**

**ALTER TABLE comum.unidade ADD CONSTRAINT unidade_unidade_responsavel_fkey FOREIGN KEY (unidade_responsavel) REFERENCES comum.unidade(id_unidade);**

## Montagem do arquivo de servidores
Substituir o arquivo servidores.txt dentro do diretório /arquivo_entrada presente na raiz do projeto.

O arquivo: **servidores.txt** deverá ter as seguintes informações dos servidores, separados por ponto e vírgula (;) na seguinte ORDEM:

- Matrícula SIAPE do servidor; (Valor numérico)
- Dígito SIAPE do servidor; (Valor numérico)
- Nome Completo do servidor; (Valor alfanumérico)
- CPF do servidor; (Valor numérico)
- PIS/PASEP; (Valor numérico)
- Nome da mãe; (Valor alfanumérico)
- Sexo; (Valores possíveis: M ou F)
- Data de Nascimento; (Data/formato: 01012000) 
- Estado Civil; (Valor numérico de 1 dígito extraído da tabela: rh_tipos.tipo_estado_civil - Coluna: id_tipo_estado_civil)
- Escolaridade; (Valor numérico de 2 dígitos extraído da tabela: rh.escolaridade - Coluna: id_escolaridade)
- Formação Acadêmica; (Valor numérico de 2 dígitos extraído da tabela: rh.formacao - Coluna: id_formacao)
- Nacionalidade; (Valor padrão numérico = 1)
- Sigla Naturalidade; (Ex: RN)
- Endereço; (Valor alfanumérico)
- Número; (Valor alfanumérico)
- Complemento do endereço; (Valor alfanumérico - Obs: Deixar um espaço em branco, caso não exista.)
- Bairro; (Valor alfanumérico)
- Município; (Valor alfanumérico)
- CEP; (Valor numérico - ex: 59000000)
- Unidade Federativa; (Ex: RN)
- RG; (valor alfanumérico)
- Órgão Expedidor do RG; (Valor alfanumérico)
- Data Expedição do RG; (Data/formato: 01012000)
- UF do RG; (Ex: RN)
- Título de Eleitor; (Numérico)
- Sigla do Regime Jurídico; (Sigla de 3 dígitos extraída da tabela: rh_tipos.tipo_regime_juridico - Coluna: Sigla - Exemplo: EST)
- Situação funcional do servidor; (Valor numérico de 2 dígitos extraído da tabela: rh.situacao_servidor - Coluna: id_situacao)
- Banco; (Valor numérico de 3 dígitos extraído da tabela: comum.banco - Coluna: codigo - Obs: Deixar com valor 0, caso não exista)
- Agência; (Valor alfanumérico - Deixar um espaço em branco, caso não exista) 
- Conta Bancária; (Valor alfanumérico - Deixar um espaço em branco, caso não exista)
- Jornada de Trabalho; (Ex: 20, 40 - DE são registrados como 99)
- Data de Cadastro do servidor; (Data/formato: 01012000)
- Grupo Cargo; (3 primeiros valores numéricos extraídos da tabela: rh.cargo - Coluna: id - Obs: Deixar com valor 0, caso não exista)
- Cargo; (3 últimos valores numéricos extraídos da tabela: rh.cargo - Coluna: id - Obs: Deixar com valor 0, caso não exista)
- Classe Cargo; (Valor alfanumérico de 1 dígito extraído da tabela: rh.classe_funcional - Coluna: sigla - Deixar um espaço em branco, caso não exista)
- Nível Cargo; (Valor alfanumérico - 3 dígitos - Deixar um espaço em branco, caso não exista)
- Data de Entrada do servidor no cargo; (Data/formato: 01012000)
- Data de Saída do servidor no cargo; (Data/formato: 01012000 - Obs: Deixar com valor 0, caso não exista.) 
- Unidade de Lotação do servidor; (Codigo SIAPECAD da unidade de lotação do servidor. Deve existir este código na tabela de unidades: select codigo_siapecad from comum.unidade)	
- Data de ingresso na unidade; (Data/formato: 01012000)
- Data de admissão no órgão; (Data/formato: 01012000)
- Data de admissão no serviço público; (Data/formato: 01012000) 

Ao executar a aplicação, junto a classe: Index.java deve-se selecionar a opção: 1 - Gerar Fita Espelho SERVIDORES.

Em seguida serão apresentadas as seguintes perguntas:

	Informe a sigla da instituição (UFRN): 
	Informe o mês desejado (7): 
	Informe o ano desejado (2026): 
	Informe o código SIAPECAD da unidade pagadora (1): 
	Informe a UF da unidade pagadora (RN): 

Por fim, será gerado um arquivo de saída dentro do diretório: arquivo_saida, denominado: fita_espelho_mes_ano.txt.

Atenção: No caso específico, apresentado acima foi gerada uma fita para o mês de julho, junto ao ano de 2026. Deverá existir na base uma unidade com o código SIAPECAD informado. Em geral a unidade raiz possui SIAPECAD padrão no valor de 1, mas isto pode ser atualizado pela instituição. (select * from comum.unidade where codigo_siapecad = 1)

## Importando o arquivo de servidores no SIGRH
Após geração do arquivo de servidores, realizar a importação do arquivo junto ao sistema através da operação presente em: **SIGRH -> Módulo: Administração de Pessoal -> Aba: Administração -> Fita-Espelho -> Fita Espelho SIAPE (Novo) -> Processamento -> Carregar Arquivo. OBS: Neste etapa anexar o arquivo correspondente ao mês/ano referência gerado.**

Após carregamento do arquivo, realizar o seu processamento em: **SIGRH -> Módulo: Administração de Pessoal -> Aba: Administração -> Fita-Espelho -> Fita Espelho SIAPE (Novo) -> Processamento -> Processar Fita-Espelho.** Os servidores importados serão apresentados com status: SUCESSO, e os não importados serão apresentados com status: FALHA.

Após finalização do procedimento, os servidores serão criadas, junto de sua hierarquia junto aos bancos: administrativo, sistemas_comum e sigaa.
