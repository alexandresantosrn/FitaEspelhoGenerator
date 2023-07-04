# FitaEspelhoGenerator
Aplicação de apoio para geração dos dados para fita-espelho SIAPE.

## Execução
Executar o projeto no Eclipse (Qualquer versão atual) na versão 17 do Java.
Criar a pasta tempo junto a raiz C do computador. Ex: C:/temp
Adicionar o arquivo servidores.txt dentro desta pasta.
O arquivo: servidores.txt deverá ter as seguintes informações dos servidores, separados por ponto e vírgula (;) na seguinte ORDEM:

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
- País; (Valor padrão: 000)
- Endereço; (Valor alfanumérico)
- Número; (Valor alfanumérico)
- Complemento do endereço; (Valor alfanumérico - Obs: Deixar vazio, caso não exista.)
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
- Banco; (Valor numérico de 3 dígitos extraído da tabela: comum.banco - Coluna: codigo)
- Agência; (Valor alfanumérico) 
- Conta Bancária; (Valor alfanumérico)
- Jornada de Trabalho; (Ex: 20, 40 - DE são registrados como 99)
- Data de Cadastro do servidor; (Data/formato: 01012000)
- Grupo Cargo; (3 primeiros valores numéricos extraídos da tabela: rh.cargo - Coluna: id)
- Cargo; (3 últimos valores numéricos extraídos da tabela: rh.cargo - Coluna: id)
- Classe Cargo; (Valor alfanumérico de 1 dígito extraído da tabela: rh.classe_funcional - Coluna: sigla - Deixar em branco, caso não exista)
- Nível Cargo; (Valor alfanumérico - 3 dígitos - Deixar em branco, caso não exista)
- Data de Entrada do servidor no cargo; (Data/formato: 01012000)
- Data de Saída do servidor no cargo; (Data/formato: 01012000 - Obs: Deixar com valor 0, caso não exista.) 
- Unidade de Lotação do servidor; (Codigo SIAPECAD da unidade de lotação do servidor. Deve existir este código na tabela de unidades: select codigo_siapecad from comum.unidade)	
- Data de ingresso na unidade; (Data/formato: 01012000)
- Data de admissão no órgão; (Data/formato: 01012000)
- Data de admissão no serviço público; (Data/formato: 01012000) 

Ao rodar a classe: Index.java deve-se selecionar a opção: 1 - Importar Arquivo.
Em seguida serão apresentadas as seguintes perguntas:
- Informe o código da instituição: 00001
- Informe a sigla da instituição: UFRN
- Informe o mês desejado: 06
- Informe o ano desejado: 2023
- Informe o código SIAPECAD da unidade pagadora: 38000
- Informe a UF da unidade pagadora: RN

A seguir, embora seja sexibido um erro no Eclipse será gerado um arquivo de saída dentro da onde o projeto roda, denominado: file.txt. 
Atenção: No caso específico, apresentado acima foi gerada uma fita para o mês de junho, junto ao ano de 2023.
Deverá existir na base uma unidade com o código SIAPECAD informado. Em geral a unidade raiz possui SIAPECAD padrão no valor de 38.000, mas isto pode ser atualizado pela instituição. (select * from comum.unidade where codigo_siapecad = 38000)

