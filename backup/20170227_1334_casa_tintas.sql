-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 27, 2017 at 05:34 
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `casa_tintas`
--

-- --------------------------------------------------------

--
-- Table structure for table `bases_tinta`
--

CREATE TABLE `bases_tinta` (
  `id` int(11) NOT NULL,
  `id_tinta` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `cod_base` varchar(10) NOT NULL,
  `quantidade` decimal(10,3) NOT NULL,
  `sigla_unidade` char(2) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bases_tinta`
--

INSERT INTO `bases_tinta` (`id`, `id_tinta`, `id_produto`, `cod_base`, `quantidade`, `sigla_unidade`, `data_inclusao`, `data_modificacao`) VALUES
(1, 1, 9, '4100', '2102.500', 'gr', '2016-10-24 03:00:37', '2016-10-24 03:00:37'),
(2, 1, 10, '4840', '2.200', 'gr', '2016-10-24 03:02:31', '2016-10-24 03:02:31'),
(3, 1, 11, '4652', '2.200', 'gr', '2016-10-24 03:06:27', '2016-10-24 03:31:59'),
(5, 1, 12, '4700', '2.600', 'gr', '2016-10-24 03:30:19', '2016-10-24 03:31:02'),
(6, 1, 13, '4000', '1558.900', 'gr', '2016-10-24 03:30:36', '2016-10-24 03:31:14'),
(7, 1, 14, '7012', '74.900', 'gr', '2016-10-24 03:31:25', '2016-10-24 03:31:25'),
(8, 2, 39, '4260', '1399.000', 'gr', '2016-11-16 14:25:30', '2016-11-16 14:25:30'),
(9, 2, 10, '4840', '15.300', 'gr', '2016-11-16 14:25:45', '2016-11-16 14:25:45'),
(10, 2, 9, '4100', '46.200', 'gr', '2016-11-16 14:26:00', '2016-11-16 14:26:00'),
(11, 2, 37, '4232', '793.000', 'gr', '2016-11-16 14:26:54', '2016-11-16 14:26:54'),
(12, 2, 13, '4000', '985.400', 'gr', '2016-11-16 14:27:22', '2016-11-16 14:27:22'),
(13, 2, 14, '7012', '66.100', 'gr', '2016-11-16 14:27:34', '2016-11-16 14:27:34'),
(14, 3, 13, '4000', '2051.800', 'gr', '2016-11-16 14:32:39', '2016-11-16 14:32:39'),
(15, 3, 9, '4100', '1446.300', 'gr', '2016-11-16 14:32:58', '2016-11-16 14:32:58'),
(16, 3, 10, '4840', '3.700', 'gr', '2016-11-16 14:33:11', '2016-11-16 14:33:11'),
(17, 3, 42, '4432', '6.000', 'gr', '2016-11-16 14:34:02', '2016-11-16 14:34:02'),
(18, 3, 14, '7012', '71.600', 'gr', '2016-11-16 14:34:14', '2016-11-16 14:34:14'),
(19, 4, 13, '4000', '1940.200', 'gr', '2016-11-16 14:37:04', '2016-11-16 14:37:04'),
(20, 4, 45, '4621', '775.900', 'gr', '2016-11-16 14:37:15', '2016-11-16 14:37:15'),
(21, 4, 10, '4840', '20.800', 'gr', '2016-11-16 14:37:28', '2016-11-16 14:37:28'),
(22, 4, 9, '4100', '116.000', 'gr', '2016-11-16 14:38:41', '2016-11-16 14:38:41'),
(23, 4, 44, '4560', '354.800', 'gr', '2016-11-16 14:38:54', '2016-11-16 14:38:54'),
(24, 4, 14, '7012', '65.500', 'gr', '2016-11-16 14:39:13', '2016-11-16 14:39:13');

-- --------------------------------------------------------

--
-- Table structure for table `caixas`
--

CREATE TABLE `caixas` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `tipo` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'normal ou cofre',
  `data_abertura` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fechamento` timestamp NULL DEFAULT NULL,
  `saldo_final` decimal(10,3) DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `categorias_produto`
--

CREATE TABLE `categorias_produto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorias_produto`
--

INSERT INTO `categorias_produto` (`id`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'base de tinta', '2016-10-03 18:49:19', '2016-10-03 18:50:38'),
(2, 'tinta produzida', '2016-10-03 18:49:19', '2016-10-03 18:50:46'),
(3, 'embalagem', '2016-10-08 16:44:44', '2016-10-24 15:19:50'),
(4, 'verniz automotivo PU', '2016-10-08 16:44:53', '2016-10-08 16:46:11'),
(5, 'esmalte sintético', '2016-10-08 16:45:04', '2016-10-08 16:45:04'),
(10, 'categoria produto 01', '2016-10-08 16:52:48', '2016-10-08 16:52:48'),
(11, 'categoria produto 02', '2016-10-08 16:52:55', '2016-10-08 16:52:55'),
(12, 'lixa', '2016-10-30 00:37:32', '2016-10-30 00:37:32');

-- --------------------------------------------------------

--
-- Table structure for table `categorias_tinta`
--

CREATE TABLE `categorias_tinta` (
  `id` int(11) NOT NULL,
  `descricao` varchar(15) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorias_tinta`
--

INSERT INTO `categorias_tinta` (`id`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'metálico', '2016-10-03 18:48:17', '2016-10-03 18:48:17'),
(2, 'liso/sólido', '2016-10-03 18:48:17', '2016-10-08 16:57:35'),
(3, 'perolizado', '2016-10-03 18:48:24', '2016-10-03 18:48:24'),
(7, 'cat tinta 01', '2016-10-08 17:17:04', '2016-10-08 17:17:04'),
(8, 'cat tinta 02', '2016-10-08 17:17:08', '2016-10-08 17:17:08');

-- --------------------------------------------------------

--
-- Table structure for table `cfop`
--

CREATE TABLE `cfop` (
  `codigo` smallint(6) NOT NULL,
  `descricao` varchar(350) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cfop`
--

INSERT INTO `cfop` (`codigo`, `descricao`) VALUES
(1000, 'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DO ESTADO'),
(1100, 'COMPRAS PARA INDUSTRIALIZAÇÃO, PRODUÇÃO RURAL, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS (Ajuste SINIEF 05/05)'),
(1101, 'Compra para industrialização ou produção rural'),
(1102, 'Compra para comercialização'),
(1111, 'Compra para industrialização de mercadoria recebida anteriormente em consignação industrial'),
(1113, 'Compra para comercialização, de mercadoria recebida anteriormente em consignação mercantil'),
(1116, 'Compra para industrialização ou produção rural originada de encomenda para recebimento futuro'),
(1117, 'Compra para comercialização originada de encomenda para recebimento futuro'),
(1118, 'Compra de mercadoria para comercialização pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem'),
(1120, 'Compra para industrialização, em venda à ordem, já recebida do vendedor remetente'),
(1121, 'Compra para comercialização, em venda à ordem, já recebida do vendedor remetente'),
(1122, 'Compra para industrialização em que a mercadoria foi remetida pelo fornecedor ao industrializador sem transitar pelo estabelecimento adquirente'),
(1124, 'Industrialização efetuada por outra empresa'),
(1125, 'Industrialização efetuada por outra empresa quando a mercadoria remetida para utilização no processo de industrialização não transitou pelo estabelecimento adquirente da mercadoria'),
(1126, 'Compra para utilização na prestação de serviço'),
(1150, 'TRANSFERÊNCIAS PARA INDUSTRIALIZAÇÃO, PRODUÇÃO RURAL, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS (Ajuste SINIEF 05/05)'),
(1151, 'Transferência para industrialização ou produção rural'),
(1152, 'Transferência para comercialização'),
(1153, 'Transferência de energia elétrica para distribuição'),
(1154, 'Transferência para utilização na prestação de serviço'),
(1200, 'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES'),
(1201, 'Devolução de venda de produção do estabelecimento'),
(1202, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros'),
(1203, 'Devolução de venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(1204, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(1205, 'Anulação de valor relativo à prestação de serviço de comunicação'),
(1206, 'Anulação de valor relativo à prestação de serviço de transporte'),
(1207, 'Anulação de valor relativo à venda de energia elétrica'),
(1208, 'Devolução de produção do estabelecimento, remetida em transferência'),
(1209, 'Devolução de mercadoria adquirida ou recebida de terceiros, remetida em transferência'),
(1250, 'COMPRAS DE ENERGIA ELÉTRICA'),
(1251, 'Compra de energia elétrica para distribuição ou comercialização'),
(1252, 'Compra de energia elétrica por estabelecimento industrial'),
(1253, 'Compra de energia elétrica por estabelecimento comercial'),
(1254, 'Compra de energia elétrica por estabelecimento prestador de serviço de transporte'),
(1255, 'Compra de energia elétrica por estabelecimento prestador de serviço de comunicação'),
(1256, 'Compra de energia elétrica por estabelecimento de produtor rural'),
(1257, 'Compra de energia elétrica para consumo por demanda contratada'),
(1300, 'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(1301, 'Aquisição de serviço de comunicação para execução de serviço da mesma natureza'),
(1302, 'Aquisição de serviço de comunicação por estabelecimento industrial'),
(1303, 'Aquisição de serviço de comunicação por estabelecimento comercial'),
(1304, 'Aquisição de serviço de comunicação por estabelecimento de prestador de serviço de transporte'),
(1305, 'Aquisição de serviço de comunicação por estabelecimento de geradora ou de distribuidora de energia elétrica'),
(1306, 'Aquisição de serviço de comunicação por estabelecimento de produtor rural'),
(1350, 'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE'),
(1351, 'Aquisição de serviço de transporte para execução de serviço da mesma natureza'),
(1352, 'Aquisição de serviço de transporte por estabelecimento'),
(1353, 'Aquisição de serviço de transporte por estabelecimento comercial'),
(1354, 'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação'),
(1355, 'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica'),
(1356, 'Aquisição de serviço de transporte por estabelecimento de produtor rural'),
(1360, 'Aquisição de serviço de transporte por contribuinte substituto em relação ao serviço de transporte (Ajuste SINIEF 06/07)'),
(1400, 'ENTRADAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA'),
(1401, 'Compra para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(1403, 'Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(1406, 'Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária'),
(1407, 'Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária'),
(1408, 'Transferência para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(1409, 'Transferência para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(1410, 'Devolução de venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(1411, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária'),
(1414, 'Retorno de produção do estabelecimento, remetida para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(1415, 'Retorno de mercadoria adquirida ou recebida de terceiros, remetida para venda fora do estabelecimento em operação com mercadoria sujeita ao regime de substituição tributária'),
(1450, 'SISTEMAS DE INTEGRAÇÃO'),
(1451, 'Retorno de animal do estabelecimento produtor'),
(1452, 'Retorno de insumo não utilizado na produção'),
(1500, 'ENTRADAS DE MERCADORIAS REMETIDAS PARA FORMAÇÃO DE LOTE OU COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES (Ajuste SINIEF 09/05)'),
(1501, 'Entrada de mercadoria recebida com fim específico de exportação'),
(1503, 'Entrada decorrente de devolução de produto remetido com fim específico de exportação, de produção do estabelecimento'),
(1504, 'Entrada decorrente de devolução de mercadoria remetida com fim específico de exportação, adquirida ou recebida de terceiros'),
(1505, 'Entrada decorrente de devolução simbólica de mercadorias remetidas para formação de lote de exportação, de produtos industrializados ou produzidos pelo próprio estabelecimento (Ajuste SINIEF 09/)'),
(1506, 'Entrada decorrente de devolução simbólica de mercadorias, adquiridas ou recebidas de terceiros, remetidas para formação de lote de exportação (Ajuste SINIEF 09/05)'),
(1550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(1551, 'Compra de bem para o ativo imobilizado'),
(1552, 'Transferência de bem do ativo'),
(1553, 'Devolução de venda de bem do ativo imobilizado'),
(1554, 'Retorno de bem do ativo imobilizado remetido para uso fora do estabelecimento'),
(1555, 'Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento'),
(1556, 'Compra de material para uso ou consumo'),
(1557, 'Transferência de material para uso ou consumo'),
(1600, 'CRÉDITOS E RESSARCIMENTOS DE ICMS'),
(1601, 'Recebimento, por transferência, de crédito de ICMS'),
(1602, 'Recebimento, por transferência, de saldo credor de ICMS de outro estabelecimento da mesma empresa, para compensação de saldo devedor de ICMS'),
(1603, 'Ressarcimento de ICMS retido por substituição tributária'),
(1604, 'Lançamento do crédito relativo à compra de bem para o ativo imobilizado (Ajuste SINIEF 05/02)'),
(1605, 'Recebimento, por transferência, de saldo devedor de ICMS de outro estabelecimento da mesma empresa (Ajuste SINIEF 03/04)'),
(1650, 'ENTRADAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(1651, 'Compra de combustível ou lubrificante para industrialização subseqüente'),
(1652, 'Compra de combustível ou lubrificante para comercialização'),
(1653, 'Compra de combustível ou lubrificante por consumidor ou usuário final'),
(1658, 'Transferência de combustível e lubrificante para industrialização'),
(1659, 'Transferência de combustível e lubrificante para comercialização'),
(1660, 'Devolução de venda de combustível ou lubrificante destinado à industrialização subseqüente'),
(1661, 'Devolução de venda de combustível ou lubrificante destinado à comercialização'),
(1662, 'Devolução de venda de combustível ou lubrificante destinado a consumidor ou usuário final'),
(1663, 'Entrada de combustível ou lubrificante para armazenagem'),
(1664, 'Retorno de combustível ou lubrificante remetido para armazenagem'),
(1900, 'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS'),
(1901, 'Entrada para industrialização por encomenda'),
(1902, 'Retorno de mercadoria remetida para industrialização por encomenda'),
(1903, 'Entrada de mercadoria remetida para industrialização e não aplicada no referido processo'),
(1904, 'Retorno de remessa para venda fora do estabelecimento'),
(1905, 'Entrada de mercadoria recebida para depósito em depósito fechado ou armazém geral'),
(1906, 'Retorno de mercadoria remetida para depósito fechado ou armazém geral'),
(1907, 'Retorno simbólico de mercadoria remetida para depósito fechado ou armazém geral'),
(1908, 'Entrada de bem por conta de contrato de comodato'),
(1909, 'Retorno de bem remetido por conta de contrato de comodato'),
(1910, 'Entrada de bonificação, doação ou brinde'),
(1911, 'Entrada de amostra grátis'),
(1912, 'Entrada de mercadoria ou bem recebido para demonstração'),
(1913, 'Retorno de mercadoria ou bem remetido para demonstração'),
(1914, 'Retorno de mercadoria ou bem remetido para exposição ou feira'),
(1915, 'Entrada de mercadoria ou bem recebido para conserto ou reparo'),
(1916, 'Retorno de mercadoria ou bem remetido para conserto ou reparo'),
(1917, 'Entrada de mercadoria recebida em consignação mercantil ou industrial'),
(1918, 'Devolução de mercadoria remetida em consignação mercantil ou industrial'),
(1919, 'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, remetida anteriormente em consignação mercantil ou industrial'),
(1920, 'Entrada de vasilhame ou sacaria'),
(1921, 'Retorno de vasilhame ou sacaria'),
(1922, 'Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro'),
(1923, 'Entrada de mercadoria recebida do vendedor remetente, em venda à ordem'),
(1924, 'Entrada para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(1925, 'Retorno de mercadoria remetida para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(1926, 'Lançamento efetuado a título de reclassificação de mercadoria decorrente de formação de \"kit\" ou de sua desagregação'),
(1931, 'Lançamento efetuado pelo tomador do serviço de transporte quando a responsabilidade de retenção do imposto for atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço (Ajuste SINIEF 03/04)'),
(1932, 'Aquisição de serviço de transporte iniciado em unidade da Federação diversa daquela onde inscrito o prestador (Ajuste SINIEF 03/04)'),
(1933, 'Aquisição de serviço tributado pelo ISSQN (Ajuste SINIEF 03/04)'),
(1949, 'Outra entrada de mercadoria ou prestação de serviço não especificada'),
(2000, 'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DE OUTROS ESTADOS'),
(2100, 'COMPRAS PARA INDUSTRIALIZAÇÃO, PRODUÇÃO RURAL, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS (Ajuste SINIEF 05/05)'),
(2101, 'Compra para industrialização ou produção rural'),
(2102, 'Compra para comercialização'),
(2111, 'Compra para industrialização de mercadoria recebida anteriormente em consignação industrial'),
(2113, 'Compra para comercialização, de mercadoria recebida anteriormente em consignação mercantil'),
(2116, 'Compra para industrialização ou produção rural originada de encomenda para recebimento futuro'),
(2117, 'Compra para comercialização originada de encomenda para recebimento futuro'),
(2118, 'Compra de mercadoria para comercialização pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem'),
(2120, 'Compra para industrialização, em venda à ordem, já recebida do vendedor remetente'),
(2121, 'Compra para comercialização, em venda à ordem, já recebida do vendedor remetente'),
(2122, 'Compra para industrialização em que a mercadoria foi remetida pelo fornecedor ao industrializador sem transitar pelo estabelecimento adquirente'),
(2124, 'Industrialização efetuada por outra empresa'),
(2125, 'Industrialização efetuada por outra empresa quando a mercadoria remetida para utilização no processo de industrialização não transitou pelo estabelecimento adquirente da mercadoria'),
(2126, 'Compra para utilização na prestação de serviço'),
(2150, 'TRANSFERÊNCIAS PARA INDUSTRIALIZAÇÃO, PRODUÇÃO RURAL, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS (Ajuste SINIEF 05/05)'),
(2151, 'Transferência para industrialização ou produção rural'),
(2152, 'Transferência para comercialização'),
(2153, 'Transferência de energia elétrica para distribuição'),
(2154, 'Transferência para utilização na prestação de serviço'),
(2200, 'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES'),
(2201, 'Devolução de venda de produção do estabelecimento'),
(2202, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros'),
(2203, 'Devolução de venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(2204, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(2205, 'Anulação de valor relativo à prestação de serviço de comunicação'),
(2206, 'Anulação de valor relativo à prestação de serviço de transporte'),
(2207, 'Anulação de valor relativo à venda de energia elétrica'),
(2208, 'Devolução de produção do estabelecimento, remetida em transferência'),
(2209, 'Devolução de mercadoria adquirida ou recebida de terceiros, remetida em transferência'),
(2250, 'COMPRAS DE ENERGIA ELÉTRICA'),
(2251, 'Compra de energia elétrica para distribuição ou comercialização'),
(2252, 'Compra de energia elétrica por estabelecimento industrial'),
(2253, 'Compra de energia elétrica por estabelecimento comercial'),
(2254, 'Compra de energia elétrica por estabelecimento prestador de serviço de transporte'),
(2255, 'Compra de energia elétrica por estabelecimento prestador de serviço de comunicação'),
(2256, 'Compra de energia elétrica por estabelecimento de produtor rural'),
(2257, 'Compra de energia elétrica para consumo por demanda contratada'),
(2300, 'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(2301, 'Aquisição de serviço de comunicação para execução de serviço da mesma natureza'),
(2302, 'Aquisição de serviço de comunicação por estabelecimento industrial'),
(2303, 'Aquisição de serviço de comunicação por estabelecimento comercial'),
(2304, 'Aquisição de serviço de comunicação por estabelecimento de prestador de serviço de transporte'),
(2305, 'Aquisição de serviço de comunicação por estabelecimento de geradora ou de distribuidora de energia elétrica'),
(2306, 'Aquisição de serviço de comunicação por estabelecimento de produtor rural'),
(2350, 'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE'),
(2351, 'Aquisição de serviço de transporte para execução de serviço da mesma natureza'),
(2352, 'Aquisição de serviço de transporte por estabelecimento industrial'),
(2353, 'Aquisição de serviço de transporte por estabelecimento comercial'),
(2354, 'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação'),
(2355, 'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica'),
(2356, 'Aquisição de serviço de transporte por estabelecimento de produtor rural'),
(2400, 'ENTRADAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA'),
(2401, 'Compra para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(2403, 'Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(2406, 'Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária'),
(2407, 'Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária'),
(2408, 'Transferência para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(2409, 'Transferência para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(2410, 'Devolução de venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(2411, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária'),
(2414, 'Retorno de produção do estabelecimento, remetida para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(2415, 'Retorno de mercadoria adquirida ou recebida de terceiros, remetida para venda fora do estabelecimento em operação com mercadoria sujeita ao regime de substituição tributária'),
(2500, 'ENTRADAS DE MERCADORIAS REMETIDAS PARA FORMAÇÃO DE LOTE OU COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES (Ajuste SINIEF 09/05)'),
(2501, 'Entrada de mercadoria recebida com fim específico de exportação'),
(2503, 'Entrada decorrente de devolução de produto remetido com fim específico de exportação, de produção do estabelecimento'),
(2504, 'Entrada decorrente de devolução de mercadoria remetida com fim específico de exportação, adquirida ou recebida de terceiros'),
(2505, 'Entrada decorrente de devolução simbólica de mercadorias remetidas para formação de lote de exportação, de produtos industrializados ou produzidos pelo próprio estabelecimento (Ajuste SINIEF 09/05)'),
(2506, 'Entrada decorrente de devolução simbólica de mercadorias, adquiridas ou recebidas de terceiros, remetidas para formação de lote de exportação (Ajuste SINIEF 09/05)'),
(2550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(2551, 'Compra de bem para o ativo imobilizado'),
(2552, 'Transferência de bem do ativo imobilizado'),
(2553, 'Devolução de venda de bem do ativo imobilizado'),
(2554, 'Retorno de bem do ativo imobilizado remetido para uso fora do estabelecimento'),
(2555, 'Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento'),
(2556, 'Compra de material para uso ou consumo'),
(2557, 'Transferência de material para uso ou consumo'),
(2600, 'CRÉDITOS E RESSARCIMENTOS DE ICMS'),
(2603, 'Ressarcimento de ICMS retido por substituição tributária'),
(2650, 'ENTRADAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(2651, 'Compra de combustível ou lubrificante para industrialização subseqüente'),
(2652, 'Compra de combustível ou lubrificante para comercialização'),
(2653, 'Compra de combustível ou lubrificante por consumidor ou usuário final'),
(2658, 'Transferência de combustível e lubrificante para industrialização'),
(2659, 'Transferência de combustível e lubrificante para comercialização'),
(2660, 'Devolução de venda de combustível ou lubrificante destinado à industrialização subseqüente'),
(2661, 'Devolução de venda de combustível ou lubrificante destinado à comercialização'),
(2662, 'Devolução de venda de combustível ou lubrificante destinado a consumidor ou usuário final'),
(2663, 'Entrada de combustível ou lubrificante para armazenagem'),
(2664, 'Retorno de combustível ou lubrificante remetido para armazenagem'),
(2900, 'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS'),
(2901, 'Entrada para industrialização por encomenda'),
(2902, 'Retorno de mercadoria remetida para industrialização por encomenda'),
(2903, 'Entrada de mercadoria remetida para industrialização e não aplicada no referido processo'),
(2904, 'Retorno de remessa para venda fora do estabelecimento'),
(2905, 'Entrada de mercadoria recebida para depósito em depósito fechado ou armazém geral'),
(2906, 'Retorno de mercadoria remetida para depósito fechado ou armazém geral'),
(2907, 'Retorno simbólico de mercadoria remetida para depósito fechado ou armazém geral'),
(2908, 'Entrada de bem por conta de contrato de comodato'),
(2909, 'Retorno de bem remetido por conta de contrato de comodato'),
(2910, 'Entrada de bonificação, doação ou brinde'),
(2911, 'Entrada de amostra grátis'),
(2912, 'Entrada de mercadoria ou bem recebido para demonstração'),
(2913, 'Retorno de mercadoria ou bem remetido para demonstração'),
(2914, 'Retorno de mercadoria ou bem remetido para exposição ou feira'),
(2915, 'Entrada de mercadoria ou bem recebido para conserto ou reparo'),
(2916, 'Retorno de mercadoria ou bem remetido para conserto ou reparo'),
(2917, 'Entrada de mercadoria recebida em consignação mercantil ou industrial'),
(2918, 'Devolução de mercadoria remetida em consignação mercantil ou industrial'),
(2919, 'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, remetida anteriormente em consignação mercantil ou industrial'),
(2920, 'Entrada de vasilhame ou sacaria'),
(2921, 'Retorno de vasilhame ou sacaria'),
(2922, 'Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro'),
(2923, 'Entrada de mercadoria recebida do vendedor remetente, em venda à ordem'),
(2924, 'Entrada para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(2925, 'Retorno de mercadoria remetida para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(2931, 'Lançamento efetuado pelo tomador do serviço de transporte quando a responsabilidade de retenção do imposto for atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o'),
(2932, 'Aquisição de serviço de transporte iniciado em unidade da Federação diversa daquela onde inscrito o prestador (Ajuste SINIEF 03/04)'),
(2933, 'Aquisição de serviço tributado pelo ISSQN (Ajuste SINIEF 03/04)'),
(2949, 'Outra entrada de mercadoria ou prestação de serviço não especificado'),
(3000, 'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DO EXTERIOR'),
(3100, 'COMPRAS PARA INDUSTRIALIZAÇÃO, PRODUÇÃO RURAL, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS (Ajuste SINIEF 05/05'),
(3101, 'Compra para industrialização ou produção rural'),
(3102, 'Compra para comercialização'),
(3126, 'Compra para utilização na prestação de serviço'),
(3127, 'Compra para industrialização sob o regime de \"drawback\"'),
(3200, 'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES'),
(3201, 'Devolução de venda de produção do estabelecimento'),
(3202, 'Devolução de venda de mercadoria adquirida ou recebida de terceiros'),
(3205, 'Anulação de valor relativo à prestação de serviço de comunicação'),
(3206, 'Anulação de valor relativo à prestação de serviço de transporte'),
(3207, 'Anulação de valor relativo à venda de energia elétrica'),
(3211, 'Devolução de venda de produção do estabelecimento sob o regime de \"drawback\"'),
(3250, 'COMPRAS DE ENERGIA ELÉTRICA'),
(3251, 'Compra de energia elétrica para distribuição ou comercialização'),
(3300, 'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(3301, 'Aquisição de serviço de comunicação para execução de serviço da mesma natureza'),
(3350, 'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE'),
(3351, 'Aquisição de serviço de transporte para execução de serviço da mesma natureza'),
(3352, 'Aquisição de serviço de transporte por estabelecimento industrial'),
(3353, 'Aquisição de serviço de transporte por estabelecimento comercial'),
(3354, 'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação'),
(3355, 'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica'),
(3356, 'Aquisição de serviço de transporte por estabelecimento de produtor rural'),
(3500, 'ENTRADAS DE MERCADORIAS REMETIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES'),
(3503, 'Devolução de mercadoria exportada que tenha sido recebida com fim específico de exportação'),
(3550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(3551, 'Compra de bem para o ativo imobilizado'),
(3553, 'Devolução de venda de bem do ativo imobilizado'),
(3556, 'Compra de material para uso ou consumo'),
(3650, 'ENTRADAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(3651, 'Compra de combustível ou lubrificante para industrialização subseqüente'),
(3652, 'Compra de combustível ou lubrificante para comercialização'),
(3900, 'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS'),
(3930, 'Lançamento efetuado a título de entrada de bem sob amparo de regime especial aduaneiro de admissão temporária'),
(3949, 'Outra entrada de mercadoria ou prestação de serviço não especificado'),
(5000, 'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA O ESTADO'),
(5100, 'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS'),
(5101, 'Venda de produção do estabelecimento'),
(5102, 'Venda de mercadoria adquirida ou recebida de terceiros'),
(5103, 'Venda de produção do estabelecimento, efetuada fora do estabelecimento'),
(5104, 'Venda de mercadoria adquirida ou recebida de terceiros, efetuada fora do estabelecimento'),
(5105, 'Venda de produção do estabelecimento que não deva por ele transitar'),
(5106, 'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar'),
(5109, 'Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(5110, 'Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(5111, 'Venda de produção do estabelecimento remetida anteriormente em consignação industrial'),
(5112, 'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação industrial'),
(5113, 'Venda de produção do estabelecimento remetida anteriormente em consignação mercantil'),
(5114, 'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação mercantil'),
(5115, 'Venda de mercadoria adquirida ou recebida de terceiros, recebida anteriormente em consignação mercantil'),
(5116, 'Venda de produção do estabelecimento originada de encomenda para entrega futura'),
(5117, 'Venda de mercadoria adquirida ou recebida de terceiros, originada de encomenda para entrega futura'),
(5118, 'Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem'),
(5119, 'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem'),
(5120, 'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem'),
(5122, 'Venda de produção do estabelecimento remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente'),
(5123, 'Venda de mercadoria adquirida ou recebida de terceiros remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente'),
(5124, 'Industrialização efetuada para outra empresa'),
(5125, 'Industrialização efetuada para outra empresa quando a mercadoria recebida para utilização no processo de industrialização não transitar pelo estabelecimento adquirente da mercadoria'),
(5150, 'TRANSFERÊNCIAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS'),
(5151, 'Transferência de produção do estabelecimento'),
(5152, 'Transferência de mercadoria adquirida ou recebida de terceiros'),
(5153, 'Transferência de energia elétrica'),
(5155, 'Transferência de produção do estabelecimento, que não deva por ele transitar'),
(5156, 'Transferência de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar'),
(5200, 'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES'),
(5201, 'Devolução de compra para industrialização ou produção rural'),
(5202, 'Devolução de compra para comercialização'),
(5205, 'Anulação de valor relativo a aquisição de serviço de comunicação'),
(5206, 'Anulação de valor relativo a aquisição de serviço de transporte'),
(5207, 'Anulação de valor relativo à compra de energia elétrica'),
(5208, 'Devolução de mercadoria recebida em transferência para industrialização ou produção rural'),
(5209, 'Devolução de mercadoria recebida em transferência para comercialização'),
(5210, 'Devolução de compra para utilização na prestação de serviço'),
(5250, 'VENDAS DE ENERGIA ELÉTRICA'),
(5251, 'Venda de energia elétrica para distribuição ou comercialização'),
(5252, 'Venda de energia elétrica para estabelecimento industrial'),
(5253, 'Venda de energia elétrica para estabelecimento comercial'),
(5254, 'Venda de energia elétrica para estabelecimento prestador de serviço de transporte'),
(5255, 'Venda de energia elétrica para estabelecimento prestador de serviço de comunicação'),
(5256, 'Venda de energia elétrica para estabelecimento de produtor rural'),
(5257, 'Venda de energia elétrica para consumo por demanda contratada'),
(5258, 'Venda de energia elétrica a não contribuinte'),
(5300, 'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(5301, 'Prestação de serviço de comunicação para execução de serviço da mesma natureza'),
(5302, 'Prestação de serviço de comunicação a estabelecimento industrial'),
(5303, 'Prestação de serviço de comunicação a estabelecimento comercial'),
(5304, 'Prestação de serviço de comunicação a estabelecimento de prestador de serviço de transporte'),
(5305, 'Prestação de serviço de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica'),
(5306, 'Prestação de serviço de comunicação a estabelecimento de produtor rural'),
(5307, 'Prestação de serviço de comunicação a não contribuinte'),
(5350, 'PRESTAÇÕES DE SERVIÇOS DE TRANSPORTE'),
(5351, 'Prestação de serviço de transporte para execução de serviço da mesma natureza'),
(5352, 'Prestação de serviço de transporte a estabelecimento industrial'),
(5353, 'Prestação de serviço de transporte a estabelecimento comercial'),
(5354, 'Prestação de serviço de transporte a estabelecimento de prestador de serviço de comunicação'),
(5355, 'Prestação de serviço de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica'),
(5356, 'Prestação de serviço de transporte a estabelecimento de produtor rural'),
(5357, 'Prestação de serviço de transporte a não contribuinte'),
(5359, 'Prestação de serviço de transporte a contribuinte ou a não contribuinte quando a mercadoria transportada está dispensada de emissão de nota fiscal (Ajuste SINIEF 03/04)'),
(5400, 'SAÍDAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA'),
(5401, 'Venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária, na condição de contribuinte substituto'),
(5402, 'Venda de produção do estabelecimento de produto sujeito ao regime de substituição tributária, em operação entre contribuintes substitutos do mesmo produto'),
(5403, 'Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária, na condição de contribuinte substituto'),
(5405, 'Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária, na condição de contribuinte substituído'),
(5408, 'Transferência de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(5409, 'Transferência de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária'),
(5410, 'Devolução de compra para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(5411, 'Devolução de compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(5412, 'Devolução de bem do ativo imobilizado, em operação com mercadoria sujeita ao regime de substituição tributária'),
(5413, 'Devolução de mercadoria destinada ao uso ou consumo, em operação com mercadoria sujeita ao regime de substituição tributária'),
(5414, 'Remessa de produção do estabelecimento para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(5415, 'Remessa de mercadoria adquirida ou recebida de terceiros para venda fora do estabelecimento, em operação com mercadoria sujeita ao regime de substituição tributária'),
(5450, 'SISTEMAS DE INTEGRAÇÃO'),
(5451, 'Remessa de animal e de insumo para estabelecimento produtor'),
(5500, 'REMESSAS PARA FORMAÇÃO DE LOTE E COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES(Ajuste SINIEF 09/05)'),
(5501, 'Remessa de produção do estabelecimento, com fim específico de exportação'),
(5502, 'Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação'),
(5503, 'Devolução de mercadoria recebida com fim específico de exportação'),
(5504, 'Remessa de mercadorias para formação de lote de exportação, de produtos industrializados ou produzidos pelo próprio estabelecimento (Ajuste SINIEF 09/05)'),
(5505, 'Remessa de mercadorias, adquiridas ou recebidas de terceiros, para formação de lote de exportação (Ajuste SINIEF 09/05)'),
(5550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(5551, 'Venda de bem do ativo imobilizado'),
(5552, 'Transferência de bem do ativo imobilizado'),
(5553, 'Devolução de compra de bem para o ativo imobilizado'),
(5554, 'Remessa de bem do ativo imobilizado para uso fora do estabelecimento'),
(5555, 'Devolução de bem do ativo imobilizado de terceiro, recebido para uso no estabelecimento'),
(5556, 'Devolução de compra de material de uso ou consumo'),
(5557, 'Transferência de material de uso ou consumo'),
(5600, 'CRÉDITOS E RESSARCIMENTOS DE ICMS'),
(5601, 'Transferência de crédito de ICMS acumulado'),
(5602, 'Transferência de saldo credor de ICMS para outro estabelecimento da mesma empresa, destinado à compensação de saldo devedor de ICMS'),
(5603, 'Ressarcimento de ICMS retido por substituição tributária'),
(5606, 'Utilização de saldo credor de ICMS para extinção por compensação de débitos fiscais (Ajuste SINIEF nº 02/2005)'),
(5650, 'SAÍDAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(5651, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado à industrialização subseqüente'),
(5652, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado à comercialização'),
(5653, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado a consumidor ou usuário final'),
(5654, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado à industrialização subseqüente'),
(5655, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado à comercialização'),
(5656, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado a consumidor ou usuário final'),
(5657, 'Remessa de combustível ou lubrificante adquirido ou recebido de terceiros para venda fora do estabelecimento'),
(5658, 'Transferência de combustível ou lubrificante de produção do estabelecimento'),
(5659, 'Transferência de combustível ou lubrificante adquirido ou recebido de terceiro'),
(5660, 'Devolução de compra de combustível ou lubrificante adquirido para industrialização subseqüente'),
(5661, 'Devolução de compra de combustível ou lubrificante adquirido para comercialização'),
(5662, 'Devolução de compra de combustível ou lubrificante adquirido por consumidor ou usuário final'),
(5663, 'Remessa para armazenagem de combustível ou lubrificante'),
(5664, 'Retorno de combustível ou lubrificante recebido para armazenagem'),
(5665, 'Retorno simbólico de combustível ou lubrificante recebido para armazenagem'),
(5666, 'Remessa por conta e ordem de terceiros de combustível ou lubrificante recebido para armazenagem'),
(5900, 'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS'),
(5901, 'Remessa para industrialização por encomenda'),
(5902, 'Retorno de mercadoria utilizada na industrialização por encomenda'),
(5903, 'Retorno de mercadoria recebida para industrialização e não aplicada no referido processo'),
(5904, 'Remessa para venda fora do estabelecimento'),
(5905, 'Remessa para depósito fechado ou armazém geral'),
(5906, 'Retorno de mercadoria depositada em depósito fechado ou armazém geral'),
(5907, 'Retorno simbólico de mercadoria depositada em depósito fechado ou armazém geral'),
(5908, 'Remessa de bem por conta de contrato de comodato'),
(5909, 'Retorno de bem recebido por conta de contrato de comodato'),
(5910, 'Remessa em bonificação, doação ou brinde'),
(5911, 'Remessa de amostra grátis'),
(5912, 'Remessa de mercadoria ou bem para demonstração'),
(5913, 'Retorno de mercadoria ou bem recebido para demonstração'),
(5914, 'Remessa de mercadoria ou bem para exposição ou feira'),
(5915, 'Remessa de mercadoria ou bem para conserto ou reparo'),
(5916, 'Retorno de mercadoria ou bem recebido para conserto ou reparo'),
(5917, 'Remessa de mercadoria em consignação mercantil ou industrial'),
(5918, 'Devolução de mercadoria recebida em consignação mercantil ou industrial'),
(5919, 'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, recebida anteriormente em consignação mercantil ou industrial'),
(5920, 'Remessa de vasilhame ou sacaria'),
(5921, 'Devolução de vasilhame ou sacaria'),
(5922, 'Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura'),
(5923, 'Remessa de mercadoria por conta e ordem de terceiros, em venda à ordem'),
(5924, 'Remessa para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(5925, 'Retorno de mercadoria recebida para industrialização por conta e ordem do adquirente da mercadoria, quando aquela não transitar pelo estabelecimento do adquirente'),
(5926, 'Lançamento efetuado a título de reclassificação de mercadoria decorrente de formação de \"kit\" ou de sua desagregação'),
(5927, 'Lançamento efetuado a título de baixa de estoque decorrente de perda, roubo ou deterioração'),
(5928, 'Lançamento efetuado a título de baixa de estoque decorrente do encerramento da atividade da empresa'),
(5929, 'Lançamento efetuado em decorrência de emissão de documento fiscal relativo a operação ou prestação também registrada em equipamento Emissor de Cupom Fiscal - ECF'),
(5931, 'Lançamento efetuado em decorrência da responsabilidade de retenção do imposto por substituição tributária, atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço'),
(5932, 'Prestação de serviço de transporte iniciada em unidade da Federação diversa daquela onde inscrito o prestador'),
(5933, 'Prestação de serviço tributado pelo ISSQN (Ajuste SINIEF 03/04)'),
(5949, 'Outra saída de mercadoria ou prestação de serviço não especificado'),
(6000, 'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA OUTROS ESTADOS'),
(6100, 'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS'),
(6101, 'Venda de produção do estabelecimento'),
(6102, 'Venda de mercadoria adquirida ou recebida de terceiros'),
(6103, 'Venda de produção do estabelecimento, efetuada fora do estabelecimento'),
(6104, 'Venda de mercadoria adquirida ou recebida de terceiros, efetuada fora do estabelecimento'),
(6105, 'Venda de produção do estabelecimento que não deva por ele transitar'),
(6106, 'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar'),
(6107, 'Venda de produção do estabelecimento, destinada a não contribuinte'),
(6108, 'Venda de mercadoria adquirida ou recebida de terceiros, destinada a não contribuinte'),
(6109, 'Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(6110, 'Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio'),
(6111, 'Venda de produção do estabelecimento remetida anteriormente em consignação industrial'),
(6112, 'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação industrial'),
(6113, 'Venda de produção do estabelecimento remetida anteriormente em consignação mercantil'),
(6114, 'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação mercantil'),
(6115, 'Venda de mercadoria adquirida ou recebida de terceiros, recebida anteriormente em consignação mercantil'),
(6116, 'Venda de produção do estabelecimento originada de encomenda para entrega futura'),
(6117, 'Venda de mercadoria adquirida ou recebida de terceiros, originada de encomenda para entrega futura'),
(6118, 'Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem'),
(6119, 'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem'),
(6120, 'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem'),
(6122, 'Venda de produção do estabelecimento remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente'),
(6123, 'Venda de mercadoria adquirida ou recebida de terceiros remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente'),
(6124, 'Industrialização efetuada para outra empresa'),
(6125, 'Industrialização efetuada para outra empresa quando a mercadoria recebida para utilização no processo de industrialização não transitar pelo estabelecimento adquirente da mercadoria'),
(6150, 'TRANSFERÊNCIAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS'),
(6151, 'Transferência de produção do estabelecimento'),
(6152, 'Transferência de mercadoria adquirida ou recebida de terceiros'),
(6153, 'Transferência de energia elétrica'),
(6155, 'Transferência de produção do estabelecimento, que não deva por ele transitar'),
(6156, 'Transferência de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar'),
(6200, 'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES'),
(6201, 'Devolução de compra para industrialização ou produção rural'),
(6202, 'Devolução de compra para comercialização'),
(6205, 'Anulação de valor relativo a aquisição de serviço de comunicação'),
(6206, 'Anulação de valor relativo a aquisição de serviço de transporte'),
(6207, 'Anulação de valor relativo à compra de energia elétrica'),
(6208, 'Devolução de mercadoria recebida em transferência para industrialização ou produção rural'),
(6209, 'Devolução de mercadoria recebida em transferência para comercialização'),
(6210, 'Devolução de compra para utilização na prestação de serviço'),
(6250, 'VENDAS DE ENERGIA ELÉTRICA'),
(6251, 'Venda de energia elétrica para distribuição ou comercialização'),
(6252, 'Venda de energia elétrica para estabelecimento industrial'),
(6253, 'Venda de energia elétrica para estabelecimento comercial'),
(6254, 'Venda de energia elétrica para estabelecimento prestador de serviço de transporte'),
(6255, 'Venda de energia elétrica para estabelecimento prestador de serviço de comunicação'),
(6256, 'Venda de energia elétrica para estabelecimento de produtor rural'),
(6257, 'Venda de energia elétrica para consumo por demanda contratada'),
(6258, 'Venda de energia elétrica a não contribuinte'),
(6300, 'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(6301, 'Prestação de serviço de comunicação para execução de serviço da mesma natureza'),
(6302, 'Prestação de serviço de comunicação a estabelecimento industrial'),
(6303, 'Prestação de serviço de comunicação a estabelecimento comercial'),
(6304, 'Prestação de serviço de comunicação a estabelecimento de prestador de serviço de transporte'),
(6305, 'Prestação de serviço de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica'),
(6306, 'Prestação de serviço de comunicação a estabelecimento de produtor rural'),
(6307, 'Prestação de serviço de comunicação a não contribuinte'),
(6350, 'PRESTAÇÕES DE SERVIÇOS DE TRANSPORTE'),
(6351, 'Prestação de serviço de transporte para execução de serviço da mesma natureza'),
(6352, 'Prestação de serviço de transporte a estabelecimento industrial'),
(6353, 'Prestação de serviço de transporte a estabelecimento comercial'),
(6354, 'Prestação de serviço de transporte a estabelecimento de prestador de serviço de comunicação'),
(6355, 'Prestação de serviço de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica'),
(6356, 'Prestação de serviço de transporte a estabelecimento de produtor rural'),
(6357, 'Prestação de serviço de transporte a não contribuinte'),
(6359, 'Prestação de serviço de transporte a contribuinte ou a não contribuinte quando a mercadoria transportada está dispensada de emissão de nota fiscal (Ajuste SINIEF 03/04)'),
(6400, 'SAÍDAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA'),
(6402, 'Venda de produção do estabelecimento de produto sujeito ao regime de substituição tributária, em operação entre contribuintes substitutos do mesmo produto'),
(6403, 'Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária, na condição de contribuinte substituto'),
(6404, 'Venda de mercadoria sujeita ao regime de substituição tributária, cujo imposto já tenha sido retido anteriormente'),
(6408, 'Transferência de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(6409, 'Transferência de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária'),
(6410, 'Devolução de compra para industrialização ou produção rural em operação com mercadoria sujeita ao regime de substituição tributária'),
(6411, 'Devolução de compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária'),
(6412, 'Devolução de bem do ativo imobilizado, em operação com mercadoria sujeita ao regime de substituição tributária'),
(6413, 'Devolução de mercadoria destinada ao uso ou consumo, em operação com mercadoria sujeita ao regime de substituição tributária'),
(6414, 'Remessa de produção do estabelecimento para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária'),
(6415, 'Remessa de mercadoria adquirida ou recebida de terceiros para venda fora do estabelecimento, em operação com mercadoria sujeita ao regime de substituição tributária'),
(6500, 'REMESSAS PARA FORMAÇÃO DE LOTE E COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES (Ajuste SINIEF 09/05)'),
(6501, 'Remessa de produção do estabelecimento, com fim específico de exportação'),
(6502, 'Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação'),
(6503, 'Devolução de mercadoria recebida com fim específico de exportação'),
(6504, 'Remessa de mercadorias para formação de lote de exportação, de produtos industrializados ou produzidos pelo próprio estabelecimento (Ajuste SINIEF 09/05)'),
(6505, 'Remessa de mercadorias, adquiridas ou recebidas de terceiros, para formação de lote de exportação (Ajuste SINIEF 09/05)'),
(6550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(6551, 'Venda de bem do ativo imobilizado'),
(6552, 'Transferência de bem do ativo imobilizado'),
(6553, 'Devolução de compra de bem para o ativo imobilizado'),
(6554, 'Remessa de bem do ativo imobilizado para uso fora do estabelecimento'),
(6555, 'Devolução de bem do ativo imobilizado de terceiro, recebido para uso no estabelecimento'),
(6556, 'Devolução de compra de material de uso ou consumo'),
(6557, 'Transferência de material de uso ou consumo'),
(6600, 'CRÉDITOS E RESSARCIMENTOS DE ICMS'),
(6603, 'Ressarcimento de ICMS retido por substituição tributária'),
(6650, 'SAÍDAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(6651, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado à industrialização subseqüente'),
(6652, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado à comercialização'),
(6653, 'Venda de combustível ou lubrificante de produção do estabelecimento destinado a consumidor ou usuário final'),
(6654, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado à industrialização subseqüente'),
(6655, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado à comercialização'),
(6656, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros destinado a consumidor ou usuário final'),
(6657, 'Remessa de combustível ou lubrificante adquirido ou recebido de terceiros para venda fora do estabelecimento'),
(6658, 'Transferência de combustível ou lubrificante de produção do estabelecimento'),
(6659, 'Transferência de combustível ou lubrificante adquirido ou recebido de terceiro'),
(6660, 'Devolução de compra de combustível ou lubrificante adquirido para industrialização subseqüente'),
(6661, 'Devolução de compra de combustível ou lubrificante adquirido para comercialização'),
(6662, 'Devolução de compra de combustível ou lubrificante adquirido por consumidor ou usuário final'),
(6663, 'Remessa para armazenagem de combustível ou lubrificante'),
(6664, 'Retorno de combustível ou lubrificante recebido para armazenagem'),
(6665, 'Retorno simbólico de combustível ou lubrificante recebido para armazenagem'),
(6666, 'Remessa por conta e ordem de terceiros de combustível ou lubrificante recebido para armazenagem'),
(6900, 'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS');
INSERT INTO `cfop` (`codigo`, `descricao`) VALUES
(6901, 'Remessa para industrialização por encomenda'),
(6902, 'Retorno de mercadoria utilizada na industrialização por encomenda'),
(6903, 'Retorno de mercadoria recebida para industrialização e não aplicada no referido processo'),
(6904, 'Remessa para venda fora do estabelecimento'),
(6905, 'Remessa para depósito fechado ou armazém geral'),
(6906, 'Retorno de mercadoria depositada em depósito fechado ou armazém geral'),
(6907, 'Retorno simbólico de mercadoria depositada em depósito fechado ou armazém geral'),
(6908, 'Remessa de bem por conta de contrato de comodato'),
(6909, 'Retorno de bem recebido por conta de contrato de comodato'),
(6910, 'Remessa em bonificação, doação ou brinde'),
(6911, 'Remessa de amostra grátis'),
(6912, 'Remessa de mercadoria ou bem para demonstração'),
(6913, 'Retorno de mercadoria ou bem recebido para demonstração'),
(6914, 'Remessa de mercadoria ou bem para exposição ou feira'),
(6915, 'Remessa de mercadoria ou bem para conserto ou reparo'),
(6916, 'Retorno de mercadoria ou bem recebido para conserto ou reparo'),
(6917, 'Remessa de mercadoria em consignação mercantil ou industrial'),
(6918, 'Devolução de mercadoria recebida em consignação mercantil ou industrial'),
(6919, 'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, recebida anteriormente em consignação mercantil ou industrial'),
(6920, 'Remessa de vasilhame ou sacaria'),
(6921, 'Devolução de vasilhame ou sacaria'),
(6922, 'Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura'),
(6923, 'Remessa de mercadoria por conta e ordem de terceiros, em venda à ordem'),
(6924, 'Remessa para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente'),
(6925, 'Retorno de mercadoria recebida para industrialização por conta e ordem do adquirente da mercadoria, quando aquela não transitar pelo estabelecimento do adquirente'),
(6929, 'Lançamento efetuado em decorrência de emissão de documento fiscal relativo a operação ou prestação também registrada em equipamento Emissor de Cupom Fiscal - ECF'),
(6931, 'Lançamento efetuado em decorrência da responsabilidade de retenção do imposto por substituição tributária, atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço'),
(6932, 'Prestação de serviço de transporte iniciada em unidade da Federação diversa daquela onde inscrito o prestador'),
(6933, 'Prestação de serviço tributado pelo ISSQN (Ajuste SINIEF 03/04)'),
(6949, 'Outra saída de mercadoria ou prestação de serviço não especificado'),
(7000, 'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA O EXTERIOR'),
(7100, 'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS'),
(7101, 'Venda de produção do estabelecimento'),
(7102, 'Venda de mercadoria adquirida ou recebida de terceiros'),
(7105, 'Venda de produção do estabelecimento, que não deva por ele transitar'),
(7106, 'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar'),
(7127, 'Venda de produção do estabelecimento sob o regime de \"drawback\"'),
(7200, 'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES'),
(7201, 'Devolução de compra para industrialização ou produção rural'),
(7202, 'Devolução de compra para comercialização'),
(7205, 'Anulação de valor relativo à aquisição de serviço de comunicação'),
(7206, 'Anulação de valor relativo à aquisição de serviço de transporte'),
(7207, 'Anulação de valor relativo à compra de energia elétrica'),
(7210, 'Devolução de compra para utilização na prestação de serviço'),
(7211, 'Devolução de compras para industrialização sob o regime de \"drawback\"'),
(7250, 'VENDAS DE ENERGIA ELÉTRICA'),
(7251, 'Venda de energia elétrica para o exterior'),
(7300, 'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO'),
(7301, 'Prestação de serviço de comunicação para execução de serviço da mesma natureza'),
(7350, 'PRESTAÇÕES DE SERVIÇO DE TRANSPORTE'),
(7358, 'Prestação de serviço de transporte'),
(7500, 'EXPORTAÇÃO DE MERCADORIAS RECEBIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO'),
(7501, 'Exportação de mercadorias recebidas com fim específico de exportação'),
(7550, 'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO'),
(7551, 'Venda de bem do ativo imobilizado'),
(7553, 'Devolução de compra de bem para o ativo imobilizado'),
(7556, 'Devolução de compra de material de uso ou consumo'),
(7650, 'SAÍDAS DE COMBUSTÍVEIS, DERIVADOS OU NÃO DE PETRÓLEO E LUBRIFICANTES (Ajuste SINIEF 09/03)'),
(7651, 'Venda de combustível ou lubrificante de produção do estabelecimento'),
(7654, 'Venda de combustível ou lubrificante adquirido ou recebido de terceiros'),
(7900, 'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS'),
(7930, 'Lançamento efetuado a título de devolução de bem cuja entrada tenha ocorrido sob amparo de regime especial aduaneiro de admissão temporária'),
(7949, 'Outra saída de mercadoria ou prestação de serviço não especificado');

-- --------------------------------------------------------

--
-- Table structure for table `compras`
--

CREATE TABLE `compras` (
  `id` int(11) NOT NULL,
  `data_nf_entrada` datetime NOT NULL,
  `doc_principal_fornecedor` varchar(14) NOT NULL,
  `doc_principal_transportadora` varchar(14) DEFAULT NULL,
  `numero_nf_entrada` int(11) NOT NULL,
  `serie_nf_entrada` varchar(10) DEFAULT NULL,
  `cfop` smallint(6) NOT NULL,
  `data_emissao_nf_entrada` date NOT NULL,
  `valor_frete` decimal(10,3) DEFAULT NULL,
  `valor_total` decimal(10,3) NOT NULL,
  `ipi_total` decimal(10,3) DEFAULT NULL,
  `icms_st_total` decimal(10,3) DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `configuracoes`
--

CREATE TABLE `configuracoes` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` varchar(100) NOT NULL,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='configurações do sistema';

--
-- Dumping data for table `configuracoes`
--

INSERT INTO `configuracoes` (`id`, `descricao`, `valor`, `data_modificacao`) VALUES
(1, 'Simples nacional padrão', '5.47', '2016-10-31 12:25:38'),
(2, 'Comissão padrão', '0.75', '2016-11-01 14:37:23'),
(3, 'Modo padrão de produção de tinta', '0', '2016-10-31 16:13:24'),
(4, 'Quantidade padrão de produção de tinta', '0.9', '2016-11-01 14:36:24'),
(5, 'Cliente padrão de vendas', '00000000000', '2016-10-31 15:28:42');

-- --------------------------------------------------------

--
-- Table structure for table `contas_pagar`
--

CREATE TABLE `contas_pagar` (
  `id` int(11) NOT NULL,
  `doc_principal_fornecedor` varchar(14) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `contas_receber`
--

CREATE TABLE `contas_receber` (
  `id` int(11) NOT NULL,
  `doc_principal_cliente` varchar(14) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `contatos`
--

CREATE TABLE `contatos` (
  `id` int(11) NOT NULL,
  `doc_principal_pessoa` varchar(14) NOT NULL,
  `tipo` int(11) NOT NULL COMMENT '0=endereço, 1=telefone, 2=email',
  `descricao` varchar(250) NOT NULL,
  `padrao` tinyint(1) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contatos`
--

INSERT INTO `contatos` (`id`, `doc_principal_pessoa`, `tipo`, `descricao`, `padrao`, `data_inclusao`, `data_modificacao`) VALUES
(1, '43899351193', 0, 'rua 1,500,centro,18480000', 1, '2016-09-20 17:35:37', '2016-11-14 02:36:59');

-- --------------------------------------------------------

--
-- Table structure for table `controle_cheque_cartao`
--

CREATE TABLE `controle_cheque_cartao` (
  `id` int(11) NOT NULL,
  `doc_principal_pessoa` varchar(14) NOT NULL,
  `id_conta_receber` int(11) NOT NULL,
  `dados_adicionais` varchar(250) DEFAULT NULL,
  `valor_total` decimal(10,3) NOT NULL,
  `quantidade_parcelas` smallint(6) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `despesas_lancamentos_caixa`
--

CREATE TABLE `despesas_lancamentos_caixa` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `doc_principal_fornecedor` varchar(14) NOT NULL,
  `id_item_caixa` int(11) DEFAULT NULL,
  `numero` varchar(25) DEFAULT NULL,
  `valor` decimal(10,3) NOT NULL,
  `movimento` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0=débito, 1=crédito',
  `data_vencimento` date NOT NULL,
  `data_pagamento` date DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='despesas(conta água...) e mov. bancário(juros, taxa...)';

-- --------------------------------------------------------

--
-- Table structure for table `estados`
--

CREATE TABLE `estados` (
  `uf` char(2) NOT NULL,
  `nome_estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estados`
--

INSERT INTO `estados` (`uf`, `nome_estado`) VALUES
('AC', 'Acre'),
('AL', 'Alagoas'),
('AM', 'Amazonas'),
('AP', 'Amapá'),
('BA', 'Bahia'),
('CE', 'Ceará'),
('DF', 'Distrito Federal'),
('ES', 'Espírito Santo'),
('GO', 'Goiás'),
('MA', 'Maranhão'),
('MG', 'Minas Gerais'),
('MS', 'Mato Grosso do Sul'),
('MT', 'Mato Grosso'),
('PA', 'Pará'),
('PB', 'Paraíba'),
('PE', 'Pernambuco'),
('PI', 'Piauí'),
('PR', 'Paraná'),
('RJ', 'Rio de Janeiro'),
('RN', 'Rio Grande do Norte'),
('RO', 'Rondônia'),
('RR', 'Roraima'),
('RS', 'Rio Grande do Sul'),
('SC', 'Santa Catarina'),
('SE', 'Sergipe'),
('SP', 'São Paulo'),
('TO', 'Tocantins');

-- --------------------------------------------------------

--
-- Table structure for table `formas_pagamento`
--

CREATE TABLE `formas_pagamento` (
  `id` int(11) NOT NULL,
  `descricao` varchar(30) NOT NULL,
  `especie` smallint(6) NOT NULL DEFAULT '0' COMMENT '0=dh, 1=ch, 2=ct, 3=crediário',
  `numero_parcelas` smallint(6) NOT NULL DEFAULT '1',
  `prazo` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Em dias',
  `juros` decimal(10,3) DEFAULT NULL COMMENT 'mensal(30dd)',
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `formas_pagamento`
--

INSERT INTO `formas_pagamento` (`id`, `descricao`, `especie`, `numero_parcelas`, `prazo`, `juros`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'a vista', 0, 1, 0, '-5.000', '2016-10-03 18:36:43', '2016-11-08 11:56:52'),
(2, 'crediário', 3, 1, 30, NULL, '2016-10-03 18:37:10', '2016-10-03 18:37:10'),
(3, 'cheque 3x', 1, 3, 30, '5.000', '2016-10-03 18:38:07', '2016-10-03 18:57:33'),
(4, 'cartao a vista', 2, 1, 3, '0.000', '2016-10-03 18:38:52', '2016-11-08 11:58:50'),
(5, 'crediário especial', 3, 3, 30, '5.000', '2016-10-03 18:39:48', '2016-10-03 18:39:48');

-- --------------------------------------------------------

--
-- Table structure for table `historico`
--

CREATE TABLE `historico` (
  `id` int(11) NOT NULL,
  `nome_usuario` varchar(15) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_tarefa` int(11) NOT NULL,
  `codigo` varchar(25) DEFAULT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `historico`
--

INSERT INTO `historico` (`id`, `nome_usuario`, `data`, `id_tarefa`, `codigo`, `descricao`) VALUES
(1, 'admin', '2017-02-27 16:30:55', 21, NULL, 'acessado tarefa'),
(2, 'admin', '2017-02-27 16:31:01', 5, NULL, 'acessado tarefa'),
(3, 'admin', '2017-02-27 16:31:30', 18, NULL, 'acessado tarefa'),
(4, 'admin', '2017-02-27 16:31:57', 22, NULL, 'fechado o sistema'),
(5, 'admin', '2017-02-27 16:32:11', 21, NULL, 'acessado tarefa'),
(6, 'admin', '2017-02-27 16:32:18', 27, NULL, 'acessado tarefa'),
(7, 'admin', '2017-02-27 16:32:23', 22, NULL, 'fechado o sistema');

-- --------------------------------------------------------

--
-- Table structure for table `itens_caixa`
--

CREATE TABLE `itens_caixa` (
  `id` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descricao` varchar(100) NOT NULL,
  `valor` decimal(10,3) NOT NULL,
  `especie` smallint(6) NOT NULL DEFAULT '0' COMMENT '0=dh, 1=ch, 2=ct, 3=crediário',
  `movimento` tinyint(1) NOT NULL COMMENT '0=débito, 1=crédito',
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `itens_compras`
--

CREATE TABLE `itens_compras` (
  `id` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` decimal(10,3) NOT NULL,
  `valor_custo_unitario` decimal(10,3) NOT NULL,
  `ipi` decimal(10,3) DEFAULT NULL,
  `diferenca_icms` decimal(10,3) DEFAULT NULL,
  `icms_st` decimal(10,3) DEFAULT NULL,
  `frete` decimal(10,3) DEFAULT NULL,
  `data_vencimento_produto` date NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `itens_vendas`
--

CREATE TABLE `itens_vendas` (
  `id` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` decimal(10,3) NOT NULL,
  `unidade` varchar(2) NOT NULL,
  `valor_unitario` decimal(10,3) NOT NULL,
  `comissao` decimal(10,3) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lancamentos_conta_pagar`
--

CREATE TABLE `lancamentos_conta_pagar` (
  `id` int(11) NOT NULL,
  `id_conta_pagar` int(11) NOT NULL,
  `id_item_caixa` int(11) DEFAULT NULL,
  `numero` varchar(25) DEFAULT NULL,
  `valor` decimal(10,3) NOT NULL,
  `data_vencimento` date NOT NULL,
  `data_pagamento` date DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lancamentos_conta_receber`
--

CREATE TABLE `lancamentos_conta_receber` (
  `id` int(11) NOT NULL,
  `id_conta_receber` int(11) NOT NULL,
  `id_item_caixa` int(11) DEFAULT NULL,
  `valor` decimal(10,3) NOT NULL,
  `id_forma_pagamento` int(11) NOT NULL,
  `data_vencimento` date NOT NULL,
  `data_pagamento` date DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lancamentos_controle_cheque_cartao`
--

CREATE TABLE `lancamentos_controle_cheque_cartao` (
  `id` int(11) NOT NULL,
  `numero_parcela` int(11) NOT NULL,
  `id_controle_cheque_cartao` int(11) NOT NULL,
  `valor_parcela` decimal(10,3) NOT NULL,
  `data_vencimento` date NOT NULL,
  `data_pagamento` timestamp NULL DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `localidades`
--

CREATE TABLE `localidades` (
  `cep` int(11) NOT NULL,
  `localidade` varchar(100) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `localidades`
--

INSERT INTO `localidades` (`cep`, `localidade`, `estado`) VALUES
(18480000, 'Itaporanga', 'SP');

-- --------------------------------------------------------

--
-- Table structure for table `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `descricao` varchar(30) NOT NULL,
  `doc_principal_fornecedor` varchar(14) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `marcas`
--

INSERT INTO `marcas` (`id`, `descricao`, `doc_principal_fornecedor`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'marca a', '02333444000166', '2016-10-08 22:38:48', '2016-10-25 23:15:32'),
(2, 'marca b', '01222444000155', '2016-10-08 22:38:48', '2016-10-25 23:15:23'),
(3, 'wanda', '01222444000155', '2016-10-24 01:13:55', '2016-10-24 01:13:55'),
(4, '3M', '01222444000155', '2016-10-30 00:38:20', '2016-10-30 00:38:20');

-- --------------------------------------------------------

--
-- Table structure for table `montadoras`
--

CREATE TABLE `montadoras` (
  `sigla` varchar(2) NOT NULL,
  `descricao` varchar(15) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `montadoras`
--

INSERT INTO `montadoras` (`sigla`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
('fd', 'ford', '2016-10-08 17:50:26', '2016-11-16 14:28:21'),
('fi', 'fiat', '2016-10-08 17:50:10', '2016-10-08 17:50:10'),
('gm', 'general motors', '2016-10-03 18:32:36', '2016-10-03 18:32:36'),
('vw', 'volkswagem', '2016-10-03 18:32:36', '2016-10-03 18:32:36');

-- --------------------------------------------------------

--
-- Table structure for table `pessoas`
--

CREATE TABLE `pessoas` (
  `doc_principal` varchar(14) NOT NULL,
  `doc_secundario` varchar(12) NOT NULL,
  `tipo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0=física; 1=jurídica',
  `cliente` tinyint(1) DEFAULT NULL,
  `fornecedor` tinyint(1) DEFAULT NULL,
  `funcionario` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `fantasia` varchar(50) DEFAULT NULL,
  `estado_civil` varchar(20) DEFAULT NULL,
  `pessoa_autorizada` varchar(100) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `limite_credito` decimal(10,3) DEFAULT NULL,
  `cep_cidade_natal` int(11) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pessoas`
--

INSERT INTO `pessoas` (`doc_principal`, `doc_secundario`, `tipo`, `cliente`, `fornecedor`, `funcionario`, `nome`, `fantasia`, `estado_civil`, `pessoa_autorizada`, `data_nascimento`, `limite_credito`, `cep_cidade_natal`, `ativo`, `data_inclusao`, `data_modificacao`) VALUES
('01222444000155', '11122233344', 1, 0, 1, 0, 'Empresa teste A', 'teste', '', '', NULL, '0.000', NULL, 1, '2016-10-08 18:33:42', '2016-11-13 23:40:41'),
('02333444000166', '11122233355', 1, 0, 1, 0, 'Empresa teste B', 'teste 2', '', '', NULL, '0.000', NULL, 1, '2016-10-08 18:33:42', '2016-11-13 23:40:45'),
('43899351193', '000000000', 0, 1, 0, 1, 'admin', 'admin', 'Solteiro(a)', 'o próprio', '2000-01-01', '1000.000', 18480000, 1, '2016-09-19 23:08:15', '2017-02-27 16:18:02');

-- --------------------------------------------------------

--
-- Table structure for table `producao_tinta`
--

CREATE TABLE `producao_tinta` (
  `id` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_tinta` int(11) NOT NULL,
  `id_produto` int(11) DEFAULT NULL COMMENT 'chave estrangeira do produto gerado na produção',
  `id_embalagem` int(11) DEFAULT NULL,
  `quantidade` decimal(10,3) NOT NULL,
  `unidade` varchar(15) NOT NULL,
  `valor_total` decimal(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `codigo_barra` varchar(20) DEFAULT NULL,
  `codigo_fornecedor` varchar(10) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `estoque` decimal(13,6) NOT NULL,
  `sigla_unidade` char(2) NOT NULL,
  `quantidade_unitaria` decimal(10,3) DEFAULT '1.000' COMMENT 'usado principalmente na produção, quantidade de 1 unidade na medida da unidade de venda',
  `quantidade_producao` decimal(10,3) DEFAULT NULL COMMENT 'usado somente para bases',
  `unidade_producao` char(2) DEFAULT NULL COMMENT 'usado somente para bases',
  `fracionado` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0=quantidade em inteiros, 1=quantidade em decimal',
  `preco_custo` decimal(10,3) NOT NULL,
  `ipi` decimal(10,3) DEFAULT '0.000',
  `icms_st` decimal(10,3) DEFAULT '0.000',
  `diferenca_icms` decimal(10,3) DEFAULT '0.000',
  `simples_nacional` decimal(10,3) DEFAULT '0.000',
  `frete` decimal(10,3) DEFAULT '0.000',
  `margem` decimal(10,3) NOT NULL,
  `preco_venda` decimal(10,3) NOT NULL,
  `comissao` decimal(10,3) DEFAULT '0.000',
  `data_validade` date NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `codigo_barra`, `codigo_fornecedor`, `id_categoria`, `id_marca`, `estoque`, `sigla_unidade`, `quantidade_unitaria`, `quantidade_producao`, `unidade_producao`, `fracionado`, `preco_custo`, `ipi`, `icms_st`, `diferenca_icms`, `simples_nacional`, `frete`, `margem`, `preco_venda`, `comissao`, `data_validade`, `data_inclusao`, `data_modificacao`) VALUES
(5, 'Produto teste tinta produzida 1', '78965452225', '222.5', 1, 1, '2.550000', 'lt', '1.000', '890.000', 'gr', 1, '86.780', '5.000', '8.080', '0.000', '5.470', '14.400', '10.000', '132.045', '0.750', '2018-01-01', '2016-10-11 05:11:13', '2016-11-01 14:36:58'),
(6, 'esmalte sintético branco geada anjo 3,6l', NULL, NULL, 5, 1, '28.000000', 'un', '1.000', NULL, NULL, 0, '80.000', '5.000', '8.000', '0.000', '5.470', '0.000', '20.000', '122.526', '0.750', '2017-12-31', '2016-10-11 17:47:54', '2016-11-15 18:06:57'),
(7, 'Esmalte sintético preto cadilac 900ml', '78925256568', '568', 5, 2, '24.000000', 'un', '1.000', NULL, NULL, 0, '7.890', '5.000', '18.000', '0.000', '5.470', '6.000', '30.000', '15.958', '0.750', '2018-02-01', '2016-10-16 12:57:28', '2016-11-01 14:36:58'),
(8, 'Esmalte sintético vermelho massey fergusson', '7893652214', '214', 5, 1, '95.000000', 'un', '1.000', NULL, NULL, 0, '12.250', '5.000', '6.000', '0.000', '5.470', '0.000', '30.000', '21.319', '0.750', '2018-01-01', '2016-10-18 12:36:08', '2016-11-15 18:06:57'),
(9, 'Base wandacar branca 4100 ', NULL, '4100', 1, 3, '94.330167', 'lt', '3.600', '4285.710', 'gr', 1, '50.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '82.146', '0.750', '2018-01-01', '2016-10-24 01:25:34', '2016-11-16 15:25:42'),
(10, 'Base wandacar preto 4840', NULL, '4840', 1, 3, '99.990449', 'lt', '3.600', '3280.180', 'gr', 1, '39.500', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '64.895', '0.750', '2018-01-01', '2016-10-24 01:33:49', '2016-11-16 15:25:42'),
(11, 'Base wandacar azul beta 4652', NULL, '4652', 1, 3, '99.994561', 'lt', '3.600', '3923.705', 'gr', 1, '42.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '69.003', '0.750', '2018-01-01', '2016-10-24 01:38:00', '2016-11-16 15:25:42'),
(12, 'Base wandacar violeta transparente 4700', NULL, '4700', 1, 3, '99.992259', 'lt', '3.600', '3257.918', 'gr', 1, '41.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '67.360', '0.750', '2018-01-01', '2016-10-24 01:42:29', '2016-11-16 15:25:42'),
(13, 'Base wandacar binder 4000', NULL, '4000', 1, 3, '93.572075', 'lt', '3.600', '3214.285', 'gr', 1, '40.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '65.717', '0.750', '2018-01-01', '2016-10-24 01:45:18', '2016-11-16 15:25:42'),
(14, 'Base wandacar secante 7012', NULL, '7012', 1, 3, '99.717656', 'lt', '3.600', '3257.918', 'gr', 1, '35.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '57.502', '0.750', '2018-01-01', '2016-10-24 01:47:03', '2016-11-16 15:25:42'),
(15, 'Lata galão 3,600 lt wanda', NULL, NULL, 3, 3, '99.000000', 'un', '1.000', NULL, NULL, 0, '3.500', '5.000', '0.000', '0.000', '5.470', '0.000', '40.000', '6.833', '0.750', '2020-12-31', '2016-10-24 15:21:53', '2016-11-01 14:36:58'),
(16, 'Lata litro 0,900 lt wanda', NULL, NULL, 3, 3, '99.000000', 'un', '1.000', NULL, NULL, 0, '1.900', '5.000', '0.000', '0.000', '5.470', '0.000', '40.000', '3.710', '0.750', '2020-12-31', '2016-10-24 15:24:03', '2016-11-08 23:05:11'),
(17, 'Lata pote 0,250 lt wanda', NULL, NULL, 3, 3, '100.000000', 'un', '1.000', NULL, NULL, 0, '1.000', '5.000', '0.000', '0.000', '5.470', '0.000', '40.000', '1.952', '0.750', '2020-12-31', '2016-10-24 15:25:13', '2016-11-01 14:36:58'),
(30, 'Tinta prod. branco geada volkswagem liso/sólido esmalte sintético vw40000', NULL, 'vw40000', 2, 3, '5.400000', 'lt', '1.000', NULL, NULL, 1, '44.817', '0.000', '0.000', '0.000', '5.470', '0.000', '32.912', '73.629', '0.750', '2017-10-26', '2016-10-26 16:00:51', '2016-11-16 15:25:42'),
(31, 'lixa água 320 3M', NULL, NULL, 12, 4, '11.000000', 'fl', '1.000', NULL, NULL, 0, '0.500', '0.000', '0.000', '0.000', '5.470', '0.000', '50.000', '1.142', '0.750', '2018-01-01', '2016-10-30 00:39:39', '2016-11-18 14:26:28'),
(32, 'lixa água 150 3M', NULL, NULL, 12, 4, '150.000000', 'fl', '1.000', NULL, NULL, 0, '2.300', '0.000', '0.000', '0.000', '5.470', '0.000', '50.000', '5.254', '0.750', '2017-01-31', '2016-11-16 12:21:18', '2016-11-16 23:37:23'),
(33, 'lixa água 400 3M', NULL, NULL, 12, 4, '45.000000', 'fl', '1.000', NULL, NULL, 0, '0.550', '0.000', '0.000', '0.000', '5.470', '0.000', '50.000', '1.256', '0.750', '2018-01-01', '2016-11-16 12:22:24', '2016-11-18 14:26:53'),
(34, 'lixa água 1200 3M', NULL, NULL, 12, 4, '40.000000', 'fl', '1.000', NULL, NULL, 0, '1.200', '0.000', '0.000', '0.000', '5.470', '0.000', '50.000', '2.741', '0.750', '2018-01-01', '2016-11-16 12:23:23', '2016-11-18 14:26:14'),
(35, 'lixa água 2000 3M', NULL, NULL, 12, 4, '50.000000', 'fl', '1.000', NULL, NULL, 0, '2.300', '0.000', '0.000', '0.000', '5.470', '0.000', '50.000', '5.254', '0.750', '2018-01-01', '2016-11-16 12:24:19', '2016-11-16 12:24:19'),
(36, 'Base wandacar controlador universal de efeito 1990', NULL, '1990', 1, 3, '20.000000', 'lt', '0.900', '918.000', 'gr', 1, '21.530', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '35.372', '0.750', '2018-01-01', '2016-11-16 12:28:38', '2016-11-16 12:28:38'),
(37, 'Base wandacar laranja II 4232', NULL, '4232', 1, 3, '100.000000', 'lt', '3.600', '3397.000', 'gr', 1, '45.500', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '74.753', '0.750', '2018-01-01', '2016-11-16 12:35:41', '2016-11-16 12:40:25'),
(38, 'Base wandacar vermelho óxido 4240', NULL, '4240', 1, 3, '100.000000', 'lt', '3.600', '3710.000', 'gr', 1, '41.250', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '67.770', '0.750', '2018-01-01', '2016-11-16 12:37:25', '2016-11-16 12:37:25'),
(39, 'Base wandacar vermelho brilhante 4260', NULL, '4260', 1, 3, '20.000000', 'lt', '0.900', '825.000', 'gr', 1, '26.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '42.716', '0.750', '2018-01-01', '2016-11-16 12:38:56', '2016-11-16 12:40:07'),
(40, 'Base wandacar rosa transparente II 4276', NULL, '4276', 1, 3, '100.000000', 'lt', '3.600', '3275.000', 'gr', 1, '40.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '65.717', '0.750', '2018-01-01', '2016-11-16 12:42:02', '2016-11-16 12:42:02'),
(41, 'Base wandacar amarelo avermelhado 4424', NULL, '4424', 1, 3, '100.000000', 'lt', '3.600', '3450.000', 'gr', 1, '43.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '70.646', '0.750', '2018-01-01', '2016-11-16 12:43:47', '2016-11-16 12:43:47'),
(42, 'Base wandacar amarelo óxido 4432', NULL, '4432', 1, 3, '99.995623', 'lt', '3.600', '3700.000', 'gr', 1, '39.500', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '64.895', '0.750', '2018-01-01', '2016-11-16 12:45:35', '2016-11-16 15:24:05'),
(43, 'Base wandacar amarelo esverdeado 4452', NULL, '4452', 1, 3, '100.000000', 'lt', '3.600', '3922.000', 'gr', 1, '38.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '62.431', '0.750', '2018-01-01', '2016-11-16 12:53:46', '2016-11-16 12:53:46'),
(44, 'Base wandacar verde azulado 4560', NULL, '4560', 1, 3, '100.000000', 'lt', '3.600', '3336.000', 'gr', 1, '26.800', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '44.030', '0.750', '2018-01-01', '2016-11-16 12:54:52', '2016-11-16 12:54:52'),
(45, 'Base wandacar azul avermelhado II 4621', NULL, '4621', 1, 3, '100.000000', 'lt', '3.600', '3272.000', 'gr', 1, '23.500', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '38.609', '0.750', '2018-01-01', '2016-11-16 12:56:10', '2016-11-16 12:56:10'),
(46, 'Base wandacar violeta II 4722', NULL, '4722', 1, 3, '100.000000', 'lt', '3.600', '3295.000', 'gr', 1, '27.000', '5.000', '8.000', '0.000', '5.470', '0.000', '25.000', '44.359', '0.750', '2018-01-01', '2016-11-16 12:57:32', '2016-11-16 12:57:32'),
(47, 'Tinta prod. branco star II volkswagem liso/sólido esmalte sintético vw40001', NULL, 'vw40001', 2, 3, '2.700000', 'lt', '1.000', NULL, NULL, 1, '38.956', '0.000', '0.000', '0.000', '5.470', '0.000', '32.914', '64.003', '0.750', '2017-11-16', '2016-11-16 15:08:43', '2016-11-16 15:24:05');

-- --------------------------------------------------------

--
-- Table structure for table `promocoes`
--

CREATE TABLE `promocoes` (
  `id` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `valor_unitario` decimal(10,3) NOT NULL,
  `quantidade` decimal(10,3) NOT NULL DEFAULT '1.000',
  `data_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fim` timestamp NULL DEFAULT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Stand-in structure for view `rel_clientes_geral`
-- (See below for the actual view)
--
CREATE TABLE `rel_clientes_geral` (
`doc_principal` varchar(14)
,`doc_secundario` varchar(12)
,`tipo` varchar(8)
,`nome` varchar(100)
,`fantasia` varchar(50)
,`estado_civil` varchar(20)
,`pessoa_autorizada` varchar(100)
,`data_nascimento` varchar(10)
,`limite_credito` decimal(10,3)
,`cep_cidade_natal` varchar(11)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rel_contatos`
-- (See below for the actual view)
--
CREATE TABLE `rel_contatos` (
`id` int(11)
,`doc_principal_pessoa` varchar(14)
,`tipo` varchar(8)
,`descricao` varchar(250)
,`padrao` varchar(3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_caixas`
-- (See below for the actual view)
--
CREATE TABLE `rep_caixas` (
`id` int(11)
,`id_caixa` int(11)
,`desc_caixa` varchar(100)
,`tipo` varchar(6)
,`data_abertura` timestamp
,`data_fechamento` timestamp
,`data` timestamp
,`descricao` varchar(100)
,`valor` decimal(10,3)
,`movimento` tinyint(1)
,`credito` decimal(10,3)
,`debito` decimal(10,3)
,`saldo` decimal(11,3)
,`desc_especie` varchar(8)
,`valor_dh` decimal(11,3)
,`valor_ch` decimal(11,3)
,`valor_ct` decimal(11,3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_clientes_geral`
-- (See below for the actual view)
--
CREATE TABLE `rep_clientes_geral` (
`doc_principal` varchar(14)
,`doc_secundario` varchar(12)
,`tipo` varchar(8)
,`nome` varchar(100)
,`fantasia` varchar(50)
,`estado_civil` varchar(20)
,`pessoa_autorizada` varchar(100)
,`data_nascimento` varchar(10)
,`limite_credito` decimal(10,3)
,`cep_cidade_natal` varchar(11)
,`localidade` varchar(100)
,`estado` varchar(50)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_comissao`
-- (See below for the actual view)
--
CREATE TABLE `rep_comissao` (
`data` datetime
,`data_pesquisa` date
,`id_venda` int(11)
,`nome_usuario` varchar(15)
,`id_produto` int(11)
,`quantidade` decimal(10,3)
,`valor_unitario` decimal(10,3)
,`valor_total` decimal(20,6)
,`comissao` decimal(10,3)
,`valor_comissao` decimal(34,13)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_compras`
-- (See below for the actual view)
--
CREATE TABLE `rep_compras` (
`id` int(11)
,`data_nf_entrada` datetime
,`data` date
,`doc_principal_fornecedor` varchar(14)
,`nome_fornecedor` varchar(100)
,`doc_principal_transportadora` varchar(14)
,`nome_transportadora` varchar(100)
,`numero_nf_entrada` int(11)
,`serie_nf_entrada` varchar(10)
,`cfop` smallint(6)
,`data_emissao_nf_entrada` date
,`valor_frete` decimal(10,3)
,`valor_total` decimal(10,3)
,`ipi_total` decimal(10,3)
,`icms_st_total` decimal(10,3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_contatos`
-- (See below for the actual view)
--
CREATE TABLE `rep_contatos` (
`id` int(11)
,`doc_principal_pessoa` varchar(14)
,`tipo` varchar(8)
,`descricao` varchar(250)
,`localidade` varchar(100)
,`estado` varchar(50)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_controle_ch_ct`
-- (See below for the actual view)
--
CREATE TABLE `rep_controle_ch_ct` (
`id` int(11)
,`numero_parcela` int(11)
,`id_controle_cheque_cartao` int(11)
,`doc_principal_pessoa` varchar(14)
,`nome` varchar(100)
,`dados_adicionais` varchar(250)
,`valor_total` decimal(10,3)
,`quantidade_parcelas` smallint(6)
,`especie` varchar(6)
,`valor_parcela` decimal(10,3)
,`data_vencimento` date
,`data_pagamento` timestamp
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_despesas`
-- (See below for the actual view)
--
CREATE TABLE `rep_despesas` (
`id` int(11)
,`descricao` varchar(100)
,`doc_principal_fornecedor` varchar(14)
,`nome_fornecedor` varchar(100)
,`id_caixa` int(11)
,`id_item_caixa` int(11)
,`numero` varchar(25)
,`valor` decimal(10,3)
,`movimento` tinyint(4)
,`desc_movimento` varchar(7)
,`valor_debito` decimal(10,3)
,`valor_credito` decimal(10,3)
,`valor_movimento` decimal(11,3)
,`data_vencimento` date
,`data_pagamento` date
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_fornecedores_geral`
-- (See below for the actual view)
--
CREATE TABLE `rep_fornecedores_geral` (
`doc_principal` varchar(14)
,`doc_secundario` varchar(12)
,`tipo` varchar(8)
,`nome` varchar(100)
,`fantasia` varchar(50)
,`estado_civil` varchar(20)
,`pessoa_autorizada` varchar(100)
,`data_nascimento` date
,`limite_credito` decimal(10,3)
,`cep_cidade_natal` int(11)
,`localidade` varchar(100)
,`estado` varchar(50)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_funcionarios_geral`
-- (See below for the actual view)
--
CREATE TABLE `rep_funcionarios_geral` (
`doc_principal` varchar(14)
,`doc_secundario` varchar(12)
,`tipo` varchar(8)
,`nome` varchar(100)
,`fantasia` varchar(50)
,`estado_civil` varchar(20)
,`pessoa_autorizada` varchar(100)
,`data_nascimento` date
,`limite_credito` decimal(10,3)
,`cep_cidade_natal` int(11)
,`localidade` varchar(100)
,`estado` varchar(50)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_historico`
-- (See below for the actual view)
--
CREATE TABLE `rep_historico` (
`id` int(11)
,`nome_usuario` varchar(15)
,`data` timestamp
,`date_pesquisa` date
,`id_tarefa` int(11)
,`descricao_tarefa` varchar(250)
,`codigo` varchar(25)
,`descricao_historico` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_itens_venda`
-- (See below for the actual view)
--
CREATE TABLE `rep_itens_venda` (
`id` int(11)
,`id_venda` int(11)
,`id_produto` int(11)
,`nome` varchar(100)
,`quantidade` decimal(10,3)
,`unidade` varchar(2)
,`valor_unitario` decimal(10,3)
,`valor_total` decimal(20,6)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_lancamentos_conta_pagar_fornecedor`
-- (See below for the actual view)
--
CREATE TABLE `rep_lancamentos_conta_pagar_fornecedor` (
`id` int(11)
,`id_conta_pagar` int(11)
,`id_item_caixa` int(11)
,`id_compra` int(11)
,`doc_principal_fornecedor` varchar(14)
,`nome_fornecedor` varchar(100)
,`numero` varchar(25)
,`valor` decimal(10,3)
,`data_vencimento` date
,`data_pagamento` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_lancamentos_conta_receber`
-- (See below for the actual view)
--
CREATE TABLE `rep_lancamentos_conta_receber` (
`id` int(11)
,`id_conta_receber` int(11)
,`id_item_caixa` int(11)
,`id_venda` int(11)
,`valor` decimal(10,3)
,`id_forma_pagamento` int(11)
,`descricao` varchar(30)
,`especie` varchar(9)
,`data_vencimento` date
,`data_pagamento` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_lancamentos_conta_receber_cliente`
-- (See below for the actual view)
--
CREATE TABLE `rep_lancamentos_conta_receber_cliente` (
`id` int(11)
,`id_conta_receber` int(11)
,`id_item_caixa` int(11)
,`id_venda` int(11)
,`doc_principal_cliente` varchar(14)
,`nome_cliente` varchar(100)
,`valor` decimal(10,3)
,`id_forma_pagamento` int(11)
,`descricao` varchar(30)
,`especie` varchar(9)
,`data_vencimento` date
,`data_pagamento` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_pessoas`
-- (See below for the actual view)
--
CREATE TABLE `rep_pessoas` (
`doc_principal` varchar(14)
,`doc_secundario` varchar(12)
,`tipo` varchar(8)
,`nome` varchar(100)
,`fantasia` varchar(50)
,`estado_civil` varchar(20)
,`pessoa_autorizada` varchar(100)
,`data_nascimento` varchar(10)
,`limite_credito` decimal(10,3)
,`cep_cidade_natal` varchar(11)
,`localidade` varchar(100)
,`estado` varchar(50)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_producao_tinta`
-- (See below for the actual view)
--
CREATE TABLE `rep_producao_tinta` (
`id` int(11)
,`data` timestamp
,`id_tinta` int(11)
,`nome_tinta` varchar(100)
,`codigo_tinta` varchar(10)
,`id_produto` int(11)
,`nome_produto` varchar(100)
,`id_embalagem` int(11)
,`descricao_embalagem` varchar(100)
,`quantidade` decimal(10,3)
,`unidade` varchar(15)
,`valor_total` decimal(10,3)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_produtos`
-- (See below for the actual view)
--
CREATE TABLE `rep_produtos` (
`id` int(11)
,`nome` varchar(100)
,`codigo_barra` varchar(20)
,`codigo_fornecedor` varchar(10)
,`id_categoria` int(11)
,`categoria` varchar(100)
,`id_marca` int(11)
,`marca` varchar(30)
,`estoque` decimal(13,6)
,`sigla_unidade` char(2)
,`quantidade_unitaria` decimal(10,3)
,`quantidade_producao` decimal(10,3)
,`unidade_producao` char(2)
,`fracionado` tinyint(1)
,`desc_fracionado` varchar(3)
,`preco_custo` decimal(10,3)
,`ipi` decimal(10,3)
,`icms_st` decimal(10,3)
,`diferenca_icms` decimal(10,3)
,`frete` decimal(10,3)
,`custo_final` decimal(28,10)
,`margem` decimal(10,3)
,`simples_nacional` decimal(10,3)
,`comissao` decimal(10,3)
,`preco_venda` decimal(10,3)
,`data_validade` date
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_usuarios`
-- (See below for the actual view)
--
CREATE TABLE `rep_usuarios` (
`nome` varchar(15)
,`administrador` varchar(3)
,`descricao_tipo` varchar(25)
,`ativo` varchar(3)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_vendas`
-- (See below for the actual view)
--
CREATE TABLE `rep_vendas` (
`id` int(11)
,`data` datetime
,`doc_principal_cliente` varchar(45)
,`nome` varchar(100)
,`nome_usuario` varchar(15)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `rep_vendas_total`
-- (See below for the actual view)
--
CREATE TABLE `rep_vendas_total` (
`id_venda` int(11)
,`data_completa` datetime
,`data` date
,`hora` time
,`doc_principal_cliente` varchar(45)
,`nome_cliente` varchar(100)
,`vendedor` varchar(15)
,`valor_venda` decimal(42,6)
,`valor_parcela` decimal(32,3)
);

-- --------------------------------------------------------

--
-- Table structure for table `tarefas`
--

CREATE TABLE `tarefas` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tarefas`
--

INSERT INTO `tarefas` (`id`, `nome`, `descricao`) VALUES
(1, 'iFrmCadCategoriaProd', 'cadastro de categoria de produto'),
(2, 'iFrmCadCategoriaTinta', 'cadastro de categoria de tinta'),
(3, 'iFrmCadMarca', 'cadastro de marca'),
(4, 'iFrmCadMontadora', 'cadastro de montadora'),
(5, 'iFrmCadProduto', 'cadastro de produto'),
(6, 'iFrmCadPromocoes', 'cadastro de promoção'),
(7, 'iFrmCadTinta', 'cadastro de tinta'),
(8, 'iFrmCadTipoTinta', 'cadastro de tipo de tinta'),
(9, 'iFrmCadUnidade', 'cadastro de unidade'),
(10, 'iFrmCompra', 'compra'),
(11, 'iFrmProdTinta', 'produção de tinta'),
(12, 'iFrmVendas', 'venda'),
(13, 'iFrmCaixa', 'caixa'),
(14, 'iFrmChequeCartao', 'controle de cheque e cartão'),
(15, 'iFrmContasPagar', 'controle de conta a pagar'),
(16, 'iFrmContasReceber', 'controle de conta a receber'),
(17, 'iFrmFormasPagamento', 'cadastro de forma de pagamento'),
(18, 'iFrmCadPessoa', 'cadastro de pessoa'),
(19, 'iFrmCadTipoUsuario', 'cadastro de tipos de usuário'),
(20, 'iFrmCadUsuario', 'cadastro de usuário'),
(21, 'FrmLogin', 'login do sistema'),
(22, 'FrmPrincipal', 'tela principal do sistema'),
(23, 'iFrmPermTipoUsuario', 'permissão tipo de usuário'),
(24, 'iFrmConfiguracoes', 'configurações do sistema'),
(25, 'iFrmBackup', 'backup do sistema'),
(26, 'caixaCofre', 'caixa tipo cofre'),
(27, 'iFrmHistorico', 'histórico de usuário'),
(28, 'historicoGeral', 'histórico geral dos usuários'),
(29, 'iFrmDespesas', 'controle de despesas e movimento de caixa'),
(30, 'iFrm_rep_cliente_geral', 'relatório de clientes geral com contatos'),
(31, 'iFrmCancelarVenda', 'cancelamento de venda'),
(32, 'iFrm_rep_comissao', 'relatório de comissão'),
(33, 'iFrm_rep_lancamentos_conta_receber', 'relatório de contas a receber'),
(34, 'iFrm_rep_lancamentos_conta_pagar', 'relatório de contas a pagar'),
(35, 'iFrm_rep_producao_tinta', 'relatório de produção de tinta'),
(36, 'iFrm_rep_funcionarios_geral', 'relatório de funcionarios geral com contatos'),
(37, 'iFrm_rep_fornecedores_geral', 'relatório de fornecedores geral com contatos'),
(38, 'iFrm_rep_vendas_total', 'relatório de vendas totais'),
(39, 'iFrm_rep_produtos_vendidos', 'relatório de produtos vendidos'),
(40, 'rep_produtos_simples', 'relatório de produtos simples'),
(41, 'iFrm_rep_produtos_completo', 'relatório de produtos completo'),
(42, 'iFrm_rep_historico', 'relatório de histórico'),
(43, 'iFrm_rep_usuarios', 'relatório de usuários'),
(44, 'iFrm_rep_caixas', 'relatório de caixas'),
(45, 'iFrm_rep_controle_ch_ct', 'relatório de cheque e cartão'),
(46, 'iFrm_rep_despesas', 'relatório de despesas e lançamentos de caixa'),
(47, 'iFrm_rep_vendas_melhores_compradores', 'relatório de clientes que mais compraram'),
(48, 'iFrm_rep_promocoes', 'relatório de promoções'),
(49, 'iFrm_rep_compras_total', 'relatório de compras totais');

-- --------------------------------------------------------

--
-- Table structure for table `tarefas_tipo_usuario`
--

CREATE TABLE `tarefas_tipo_usuario` (
  `id` int(11) NOT NULL,
  `id_tipo_usuario` int(11) NOT NULL,
  `id_tarefa` int(11) NOT NULL,
  `acesso` tinyint(1) NOT NULL DEFAULT '0',
  `gravacao` tinyint(1) NOT NULL DEFAULT '0',
  `remocao` tinyint(1) NOT NULL DEFAULT '0',
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tarefas_tipo_usuario`
--

INSERT INTO `tarefas_tipo_usuario` (`id`, `id_tipo_usuario`, `id_tarefa`, `acesso`, `gravacao`, `remocao`, `data_inclusao`, `data_modificacao`) VALUES
(14, 2, 15, 1, 1, 1, '2016-10-29 18:25:05', '2016-10-29 18:25:05'),
(15, 2, 16, 1, 1, 1, '2016-10-29 18:25:05', '2016-10-29 18:25:05'),
(16, 2, 14, 1, 1, 1, '2016-10-29 18:25:05', '2016-10-29 18:25:05'),
(17, 2, 13, 1, 1, 1, '2016-10-29 18:25:05', '2016-10-29 18:25:05'),
(18, 3, 17, 1, 1, 1, '2016-10-29 18:27:23', '2016-10-29 18:27:23'),
(19, 3, 6, 1, 1, 1, '2016-10-29 18:27:23', '2016-10-29 18:27:23'),
(20, 3, 18, 1, 1, 1, '2016-10-29 18:27:23', '2016-10-29 18:27:23'),
(21, 3, 12, 0, 0, 1, '2016-10-29 18:27:23', '2016-10-29 18:27:23'),
(22, 4, 12, 1, 1, 0, '2016-10-29 18:31:01', '2016-10-29 18:31:01'),
(23, 4, 18, 1, 0, 0, '2016-10-29 18:31:01', '2016-10-29 18:31:01'),
(24, 4, 5, 1, 0, 0, '2016-10-29 18:31:01', '2016-10-29 18:31:01'),
(25, 5, 5, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(26, 5, 7, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(27, 5, 10, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(28, 5, 18, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(29, 5, 8, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(30, 5, 2, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(31, 5, 4, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(32, 5, 3, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(33, 5, 1, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(34, 5, 9, 1, 1, 1, '2016-10-29 18:36:56', '2016-10-29 18:36:56'),
(35, 6, 5, 1, 0, 0, '2016-10-29 18:40:37', '2016-10-29 18:40:37'),
(36, 8, 13, 1, 1, 1, '2016-10-29 18:41:18', '2016-10-29 23:44:29'),
(37, 7, 7, 1, 1, 0, '2016-10-29 18:43:11', '2016-10-29 18:54:26'),
(38, 7, 5, 1, 0, 0, '2016-10-29 18:43:11', '2016-10-29 18:55:19'),
(39, 7, 11, 1, 1, 1, '2016-10-29 18:43:11', '2016-10-29 19:00:37'),
(40, 1, 1, 1, 0, 0, '2016-10-30 11:33:50', '2016-10-30 11:33:50'),
(41, 1, 2, 1, 0, 0, '2016-10-30 11:35:01', '2016-10-30 11:35:01'),
(42, 1, 3, 1, 0, 0, '2016-10-30 11:35:07', '2016-10-30 11:35:07'),
(43, 1, 4, 1, 0, 0, '2016-10-30 11:35:13', '2016-10-30 11:35:13'),
(44, 1, 5, 1, 0, 0, '2016-10-30 11:35:18', '2016-10-30 11:35:18'),
(45, 1, 6, 1, 0, 0, '2016-10-30 11:36:18', '2016-10-30 11:36:18'),
(46, 1, 7, 1, 0, 0, '2016-10-30 11:38:34', '2016-10-30 11:38:34'),
(47, 1, 8, 1, 0, 0, '2016-10-30 11:38:47', '2016-10-30 11:38:47'),
(48, 1, 9, 1, 0, 0, '2016-10-30 11:38:55', '2016-10-30 11:38:55'),
(49, 1, 10, 1, 0, 0, '2016-10-30 11:39:08', '2016-10-30 11:39:08'),
(50, 1, 11, 1, 0, 0, '2016-10-30 11:39:18', '2016-10-30 11:39:18'),
(51, 1, 12, 1, 0, 0, '2016-10-30 11:39:30', '2016-10-30 11:39:30'),
(52, 1, 13, 1, 0, 0, '2016-10-30 11:39:42', '2016-11-04 02:26:10'),
(53, 1, 14, 1, 0, 0, '2016-10-30 11:39:50', '2016-10-30 11:39:50'),
(54, 1, 15, 1, 0, 0, '2016-10-30 11:40:04', '2016-11-08 22:06:21'),
(55, 1, 16, 1, 0, 0, '2016-10-30 11:40:30', '2016-10-30 11:40:30'),
(56, 1, 17, 1, 0, 0, '2016-10-30 11:41:28', '2016-10-30 11:41:28'),
(57, 1, 18, 1, 0, 0, '2016-10-30 11:41:35', '2016-10-30 11:41:35'),
(58, 1, 19, 1, 0, 0, '2016-10-30 11:42:10', '2016-10-30 11:42:10'),
(59, 1, 20, 1, 0, 0, '2016-10-30 11:42:18', '2016-10-30 11:42:18'),
(60, 1, 23, 1, 0, 0, '2016-10-30 11:42:25', '2016-11-02 11:47:58'),
(61, 1, 24, 1, 0, 0, '2016-10-31 17:07:51', '2016-10-31 17:07:51'),
(62, 1, 25, 1, 0, 0, '2016-11-01 16:41:43', '2016-11-02 11:47:23'),
(63, 1, 26, 0, 0, 0, '2016-11-04 01:19:57', '2016-11-20 19:22:41'),
(65, 4, 17, 1, 0, 0, '2016-11-08 00:39:23', '2016-11-08 00:39:23'),
(66, 1, 27, 1, 0, 0, '2016-11-11 16:57:29', '2016-11-11 16:57:29'),
(67, 1, 29, 1, 0, 0, '2016-11-12 22:21:50', '2016-11-12 22:21:50'),
(68, 1, 31, 1, 0, 0, '2016-11-15 16:01:22', '2016-11-15 16:01:22'),
(69, 4, 32, 1, 0, 0, '2016-11-15 22:12:09', '2016-11-15 22:12:09'),
(70, 1, 44, 1, 0, 0, '2016-11-20 19:21:18', '2016-11-20 19:21:18');

-- --------------------------------------------------------

--
-- Table structure for table `tintas`
--

CREATE TABLE `tintas` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cod_tinta` varchar(10) NOT NULL,
  `ano_inicial` smallint(6) DEFAULT NULL,
  `ano_final` smallint(6) DEFAULT NULL,
  `id_categoria_tinta` int(11) NOT NULL,
  `id_tipo_tinta` int(11) NOT NULL,
  `sigla_montadora` char(2) NOT NULL,
  `quantidade_producao` decimal(10,3) NOT NULL,
  `quantidade_minima` decimal(10,3) NOT NULL,
  `sigla_unidade` char(2) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tintas`
--

INSERT INTO `tintas` (`id`, `nome`, `cod_tinta`, `ano_inicial`, `ano_final`, `id_categoria_tinta`, `id_tipo_tinta`, `sigla_montadora`, `quantidade_producao`, `quantidade_minima`, `sigla_unidade`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'branco geada', 'vw40000', 1995, 2011, 2, 1, 'vw', '3.600', '0.160', 'lt', '2016-10-23 23:38:22', '2016-10-24 00:36:53'),
(2, 'vermelho ferrari', 'fi30002', 1978, 1979, 2, 1, 'fi', '3.600', '0.020', 'lt', '2016-11-16 14:24:42', '2016-11-16 14:24:42'),
(3, 'branco star II', 'vw40001', 1989, 1994, 2, 1, 'vw', '3.600', '0.100', 'lt', '2016-11-16 14:32:20', '2016-11-16 14:32:20'),
(4, 'azul oceania', 'frd50027', 2001, 2001, 2, 1, 'fd', '3.600', '0.020', 'lt', '2016-11-16 14:36:41', '2016-11-16 14:36:41');

-- --------------------------------------------------------

--
-- Table structure for table `tipos_tinta`
--

CREATE TABLE `tipos_tinta` (
  `id` int(11) NOT NULL,
  `descricao` varchar(30) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipos_tinta`
--

INSERT INTO `tipos_tinta` (`id`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'esmalte sintético', '2016-10-03 18:51:53', '2016-10-03 18:51:53'),
(2, 'poliester', '2016-10-03 18:51:53', '2016-10-03 18:51:53'),
(3, 'poliuretano(PU)', '2016-10-03 18:53:08', '2016-10-03 18:53:08'),
(4, 'lacanitrocelulose(DUCO)', '2016-10-03 18:53:08', '2016-10-03 18:53:08');

-- --------------------------------------------------------

--
-- Table structure for table `tipos_usuario`
--

CREATE TABLE `tipos_usuario` (
  `id` int(11) NOT NULL,
  `descricao` varchar(25) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipos_usuario`
--

INSERT INTO `tipos_usuario` (`id`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
(1, 'administrador', '2016-09-19 18:11:02', '2016-09-19 18:05:17'),
(2, 'gerente financeiro', '2016-09-19 18:08:41', '2016-09-19 18:08:41'),
(3, 'gerente de vendas', '2016-09-19 18:18:30', '2016-09-19 18:18:30'),
(4, 'vendedor', '2016-09-19 18:16:27', '2016-09-19 18:29:25'),
(5, 'comprador', '2016-09-19 18:26:07', '2016-09-19 18:27:31'),
(6, 'estoquista', '2016-09-19 18:30:49', '2016-09-19 18:30:49'),
(7, 'colorista', '2016-10-29 18:37:27', '2016-10-29 18:37:27'),
(8, 'caixa', '2016-10-29 18:38:56', '2016-10-29 18:38:56');

-- --------------------------------------------------------

--
-- Table structure for table `unidades`
--

CREATE TABLE `unidades` (
  `sigla` varchar(2) NOT NULL,
  `descricao` varchar(15) NOT NULL,
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unidades`
--

INSERT INTO `unidades` (`sigla`, `descricao`, `data_inclusao`, `data_modificacao`) VALUES
('cj', 'conjunto', '2016-10-06 12:48:13', '2016-10-06 13:04:02'),
('fl', 'folha', '2016-10-30 00:40:19', '2016-10-30 00:40:19'),
('gr', 'grama', '2016-10-03 17:33:30', '2016-10-03 17:33:30'),
('lt', 'litro', '2016-10-06 17:09:26', '2016-10-18 15:42:54'),
('ml', 'mililitro', '2016-10-03 17:33:30', '2016-10-03 17:33:30'),
('oz', 'onça', '2016-10-03 17:34:47', '2016-10-03 19:31:36'),
('pc', 'peça', '2016-10-03 17:33:05', '2016-10-03 17:33:05'),
('un', 'unidade', '2016-10-08 18:00:47', '2016-10-08 18:00:47');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `nome` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `doc_principal_funcionario` varchar(14) NOT NULL,
  `administrador` tinyint(1) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `data_inclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`nome`, `senha`, `doc_principal_funcionario`, `administrador`, `tipo`, `ativo`, `data_inclusao`, `data_modificacao`) VALUES
('admin', '8D969EEF6ECAD3C29A3A', '43899351193', 1, NULL, 1, '2016-09-19 23:09:15', '2017-02-27 16:24:10');

-- --------------------------------------------------------

--
-- Table structure for table `vendas`
--

CREATE TABLE `vendas` (
  `id` int(11) NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `doc_principal_cliente` varchar(45) DEFAULT NULL,
  `nome_usuario` varchar(15) NOT NULL,
  `cancelada` tinyint(1) DEFAULT '0',
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_bases_tinta`
-- (See below for the actual view)
--
CREATE TABLE `vw_bases_tinta` (
`id` int(11)
,`id_tinta` int(11)
,`id_produto` int(11)
,`nome` varchar(100)
,`cod_base` varchar(10)
,`quantidade` decimal(10,3)
,`sigla_unidade` char(2)
,`data_inclusao_base` timestamp
,`data_modificacao_base` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_bases_tinta_producao`
-- (See below for the actual view)
--
CREATE TABLE `vw_bases_tinta_producao` (
`id` int(11)
,`id_tinta` int(11)
,`id_produto` int(11)
,`nome_base` varchar(100)
,`cod_base` varchar(10)
,`quantidade` decimal(10,3)
,`unidade_base_producao` char(2)
,`quant_unit_base_producao` decimal(10,3)
,`unid_quant_unitaria` char(2)
,`quantidade_producao` decimal(10,3)
,`comissao` decimal(10,3)
,`simples_nacional` decimal(10,3)
,`preco_custo` decimal(10,3)
,`preco_venda` decimal(10,3)
,`razao_unidades` decimal(17,7)
,`estoque_atual` decimal(13,6)
,`marca_produto` int(11)
,`data_inclusao_base` timestamp
,`data_modificacao_base` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_caixa_consulta_conta_pagar`
-- (See below for the actual view)
--
CREATE TABLE `vw_caixa_consulta_conta_pagar` (
`id` int(11)
,`descricao` varchar(100)
,`tipo` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_caixa_consulta_conta_receber`
-- (See below for the actual view)
--
CREATE TABLE `vw_caixa_consulta_conta_receber` (
`id` int(11)
,`descricao` varchar(100)
,`tipo` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_caixa_consulta_venda`
-- (See below for the actual view)
--
CREATE TABLE `vw_caixa_consulta_venda` (
`id` int(11)
,`descricao` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_caixa_tipo`
-- (See below for the actual view)
--
CREATE TABLE `vw_caixa_tipo` (
`id` int(11)
,`descricao` varchar(100)
,`tipo` tinyint(1)
,`desc_tipo` varchar(6)
,`data_abertura` timestamp
,`data_fechamento` timestamp
,`saldo_final` decimal(10,3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_clientes_pesquisa_venda`
-- (See below for the actual view)
--
CREATE TABLE `vw_clientes_pesquisa_venda` (
`doc_principal` varchar(14)
,`nome` varchar(100)
,`data_nascimento` date
,`limite_credito` decimal(10,3)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_contas_pagar_pesquisa`
-- (See below for the actual view)
--
CREATE TABLE `vw_contas_pagar_pesquisa` (
`doc` varchar(14)
,`nome` varchar(100)
,`fantasia` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_contas_receber_pesquisa`
-- (See below for the actual view)
--
CREATE TABLE `vw_contas_receber_pesquisa` (
`doc` varchar(14)
,`nome` varchar(100)
,`fantasia` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_controle_cheque_cartao_especie`
-- (See below for the actual view)
--
CREATE TABLE `vw_controle_cheque_cartao_especie` (
`id` int(11)
,`doc_principal_pessoa` varchar(14)
,`nome_pessoa` varchar(100)
,`id_conta_receber` int(11)
,`dados_adicionais` varchar(250)
,`valor_total` decimal(10,3)
,`id_item_caixa` int(11)
,`especie` smallint(6)
,`desc_especie` varchar(8)
,`quantidade_parcelas` smallint(6)
,`quantidade_parcelas_abertas` bigint(21)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_controle_cheque_cartao_especie_aberto`
-- (See below for the actual view)
--
CREATE TABLE `vw_controle_cheque_cartao_especie_aberto` (
`id` int(11)
,`doc_principal_pessoa` varchar(14)
,`nome_pessoa` varchar(100)
,`id_conta_receber` int(11)
,`dados_adicionais` varchar(250)
,`valor_total` decimal(10,3)
,`id_item_caixa` int(11)
,`especie` smallint(6)
,`desc_especie` varchar(8)
,`quantidade_parcelas` smallint(6)
,`quantidade_parcelas_abertas` bigint(21)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_formas_pagamento`
-- (See below for the actual view)
--
CREATE TABLE `vw_formas_pagamento` (
`id` int(11)
,`descricao` varchar(30)
,`especie` smallint(6)
,`desc_especie` varchar(9)
,`numero_parcelas` smallint(6)
,`prazo` smallint(6)
,`juros` decimal(10,3)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_formas_pagamento_finac`
-- (See below for the actual view)
--
CREATE TABLE `vw_formas_pagamento_finac` (
`id` int(11)
,`descricao` varchar(30)
,`especie` smallint(6)
,`desc_especie` varchar(9)
,`numero_parcelas` smallint(6)
,`prazo` smallint(6)
,`juros` decimal(10,3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_fornecedores_pesquisa_compra`
-- (See below for the actual view)
--
CREATE TABLE `vw_fornecedores_pesquisa_compra` (
`doc_principal` varchar(14)
,`nome` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_historico`
-- (See below for the actual view)
--
CREATE TABLE `vw_historico` (
`id` int(11)
,`nome_usuario` varchar(15)
,`data` timestamp
,`id_tarefa` int(11)
,`descricao_tarefa` varchar(250)
,`codigo` varchar(25)
,`descricao_historico` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_itens_caixa`
-- (See below for the actual view)
--
CREATE TABLE `vw_itens_caixa` (
`id` int(11)
,`id_caixa` int(11)
,`data` timestamp
,`descricao` varchar(100)
,`valor` decimal(10,3)
,`movimento` tinyint(1)
,`credito` decimal(10,3)
,`debito` decimal(10,3)
,`especie` smallint(6)
,`desc_especie` varchar(8)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_itens_compras`
-- (See below for the actual view)
--
CREATE TABLE `vw_itens_compras` (
`id` int(11)
,`id_compra` int(11)
,`id_produto` int(11)
,`nome_produto` varchar(100)
,`quantidade` decimal(10,3)
,`valor_custo_unitario` decimal(10,3)
,`ipi` decimal(10,3)
,`diferenca_icms` decimal(10,3)
,`icms_st` decimal(10,3)
,`frete` decimal(10,3)
,`data_vencimento_produto` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_itens_vendas`
-- (See below for the actual view)
--
CREATE TABLE `vw_itens_vendas` (
`id` int(11)
,`id_venda` int(11)
,`id_produto` int(11)
,`nome_produto` varchar(100)
,`quantidade` decimal(10,3)
,`unidade` varchar(2)
,`valor_unitario` decimal(10,3)
,`total` decimal(20,6)
,`comissao` decimal(10,3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_itens_vendas_porcentagens`
-- (See below for the actual view)
--
CREATE TABLE `vw_itens_vendas_porcentagens` (
`id_venda` int(11)
,`data` datetime
,`id_produto` int(11)
,`nome` varchar(100)
,`quantidade` decimal(10,3)
,`sigla_unidade` char(2)
,`valor_unitario` decimal(10,3)
,`valor_total` decimal(20,6)
,`comissao` decimal(10,3)
,`simples_nacional` decimal(10,3)
,`margem` decimal(10,3)
,`valor_custo_total` decimal(20,6)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_lancamentos_conta_pagar_pessoa`
-- (See below for the actual view)
--
CREATE TABLE `vw_lancamentos_conta_pagar_pessoa` (
`id` int(11)
,`id_conta_pagar` int(11)
,`doc_principal_fornecedor` varchar(14)
,`id_compra` int(11)
,`id_item_caixa` int(11)
,`valor` decimal(10,3)
,`data_vencimento` date
,`data_pagamento` date
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_lancamentos_conta_receber`
-- (See below for the actual view)
--
CREATE TABLE `vw_lancamentos_conta_receber` (
`id` int(11)
,`id_conta_receber` int(11)
,`id_item_caixa` int(11)
,`valor` decimal(10,3)
,`id_forma_pagamento` int(11)
,`descricao` varchar(30)
,`desc_especie` varchar(9)
,`data_vencimento` date
,`data_pagamento` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_lancamentos_conta_receber_pessoa`
-- (See below for the actual view)
--
CREATE TABLE `vw_lancamentos_conta_receber_pessoa` (
`id` int(11)
,`id_conta_receber` int(11)
,`doc_principal_cliente` varchar(14)
,`id_venda` int(11)
,`id_item_caixa` int(11)
,`valor` decimal(10,3)
,`id_forma_pagamento` int(11)
,`data_vencimento` date
,`data_pagamento` date
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_marcas`
-- (See below for the actual view)
--
CREATE TABLE `vw_marcas` (
`id` int(11)
,`descricao` varchar(30)
,`doc_principal_fornecedor` varchar(14)
,`nome_fornecedor` varchar(100)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_produtos`
-- (See below for the actual view)
--
CREATE TABLE `vw_produtos` (
`id` int(11)
,`nome` varchar(100)
,`codigo_barra` varchar(20)
,`codigo_fornecedor` varchar(10)
,`id_categoria` int(11)
,`categoria` varchar(100)
,`id_marca` int(11)
,`marca` varchar(30)
,`estoque` decimal(13,6)
,`sigla_unidade` char(2)
,`quantidade_unitaria` decimal(10,3)
,`quantidade_producao` decimal(10,3)
,`unidade_producao` char(2)
,`fracionado` tinyint(1)
,`preco_custo` decimal(10,3)
,`ipi` decimal(10,3)
,`icms_st` decimal(10,3)
,`diferenca_icms` decimal(10,3)
,`simples_nacional` decimal(10,3)
,`frete` decimal(10,3)
,`margem` decimal(10,3)
,`preco_venda` decimal(10,3)
,`comissao` decimal(10,3)
,`data_validade` date
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_produtos_base_tinta`
-- (See below for the actual view)
--
CREATE TABLE `vw_produtos_base_tinta` (
`id` int(11)
,`nome` varchar(100)
,`codigo_fornecedor` varchar(10)
,`unidade_producao` char(2)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_promocoes`
-- (See below for the actual view)
--
CREATE TABLE `vw_promocoes` (
`id` int(11)
,`id_produto` int(11)
,`nome` varchar(100)
,`codigo_barra` varchar(20)
,`codigo_fornecedor` varchar(10)
,`valor_unitario` decimal(10,3)
,`quantidade` decimal(10,3)
,`valor_original` decimal(10,3)
,`data_inicio` timestamp
,`data_fim` timestamp
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_promocoes_ativas`
-- (See below for the actual view)
--
CREATE TABLE `vw_promocoes_ativas` (
`id` int(11)
,`id_produto` int(11)
,`nome` varchar(100)
,`codigo_barra` varchar(20)
,`codigo_fornecedor` varchar(10)
,`valor_unitario` decimal(10,3)
,`quantidade` decimal(10,3)
,`valor_original` decimal(10,3)
,`data_inicio` timestamp
,`data_fim` timestamp
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_tarefas_tipo_usuario`
-- (See below for the actual view)
--
CREATE TABLE `vw_tarefas_tipo_usuario` (
`id` int(11)
,`id_tipo_usuario` int(11)
,`descricao_tipo_usuario` varchar(25)
,`id_tarefa` int(11)
,`nome_tarefa` varchar(50)
,`descricao_tarefa` varchar(250)
,`acesso` tinyint(1)
,`acesso_desc` varchar(3)
,`gravacao` tinyint(1)
,`gravacao_desc` varchar(3)
,`remocao` tinyint(1)
,`remocao_desc` varchar(3)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_tintas`
-- (See below for the actual view)
--
CREATE TABLE `vw_tintas` (
`id` int(11)
,`nome` varchar(100)
,`cod_tinta` varchar(10)
,`ano_inicial` smallint(6)
,`ano_final` smallint(6)
,`id_categoria_tinta` int(11)
,`categoria` varchar(15)
,`id_tipo_tinta` int(11)
,`tipo` varchar(30)
,`sigla_montadora` char(2)
,`montadora` varchar(15)
,`quantidade_producao` decimal(10,3)
,`quantidade_minima` decimal(10,3)
,`sigla_unidade` char(2)
,`unidade` varchar(15)
,`data_inclusao` timestamp
,`data_modificacao` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_usuarios`
-- (See below for the actual view)
--
CREATE TABLE `vw_usuarios` (
`nome` varchar(15)
,`senha` varchar(20)
,`administrador` tinyint(1)
,`tipo` int(11)
,`descricao_tipo` varchar(25)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_usuarios_pesquisa_historico`
-- (See below for the actual view)
--
CREATE TABLE `vw_usuarios_pesquisa_historico` (
`nome_usuario` varchar(15)
,`nome_pessoa` varchar(100)
,`administrador` varchar(3)
,`desc_tipo` varchar(25)
,`ativo` varchar(3)
);

-- --------------------------------------------------------

--
-- Structure for view `rel_clientes_geral`
--
DROP TABLE IF EXISTS `rel_clientes_geral`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rel_clientes_geral`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`doc_secundario` AS `doc_secundario`,(case `pessoas`.`tipo` when 0 then 'física' else 'jurídica' end) AS `tipo`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia`,`pessoas`.`estado_civil` AS `estado_civil`,`pessoas`.`pessoa_autorizada` AS `pessoa_autorizada`,(case when isnull(`pessoas`.`data_nascimento`) then '' else `pessoas`.`data_nascimento` end) AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito`,(case when isnull(`pessoas`.`cep_cidade_natal`) then '' else `pessoas`.`cep_cidade_natal` end) AS `cep_cidade_natal`,`pessoas`.`data_inclusao` AS `data_inclusao`,`pessoas`.`data_modificacao` AS `data_modificacao` from `pessoas` where ((`pessoas`.`ativo` = 1) and (`pessoas`.`cliente` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `rel_contatos`
--
DROP TABLE IF EXISTS `rel_contatos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rel_contatos`  AS  select `contatos`.`id` AS `id`,`contatos`.`doc_principal_pessoa` AS `doc_principal_pessoa`,(case `contatos`.`tipo` when 0 then 'endereço' when 1 then 'telefone' else 'email' end) AS `tipo`,`contatos`.`descricao` AS `descricao`,(case `contatos`.`padrao` when 1 then 'sim' else 'não' end) AS `padrao`,`contatos`.`data_inclusao` AS `data_inclusao`,`contatos`.`data_modificacao` AS `data_modificacao` from `contatos` where (`contatos`.`padrao` = 1) order by `contatos`.`doc_principal_pessoa`,`contatos`.`tipo` ;

-- --------------------------------------------------------

--
-- Structure for view `rep_caixas`
--
DROP TABLE IF EXISTS `rep_caixas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_caixas`  AS  select `vw_itens_caixa`.`id` AS `id`,`vw_itens_caixa`.`id_caixa` AS `id_caixa`,`caixas`.`descricao` AS `desc_caixa`,(case `caixas`.`tipo` when 0 then 'normal' else 'cofre' end) AS `tipo`,`caixas`.`data_abertura` AS `data_abertura`,`caixas`.`data_fechamento` AS `data_fechamento`,`vw_itens_caixa`.`data` AS `data`,`vw_itens_caixa`.`descricao` AS `descricao`,`vw_itens_caixa`.`valor` AS `valor`,`vw_itens_caixa`.`movimento` AS `movimento`,`vw_itens_caixa`.`credito` AS `credito`,`vw_itens_caixa`.`debito` AS `debito`,(case when (`vw_itens_caixa`.`credito` is not null) then `vw_itens_caixa`.`credito` else (`vw_itens_caixa`.`debito` * -(1)) end) AS `saldo`,`vw_itens_caixa`.`desc_especie` AS `desc_especie`,(case when ((`vw_itens_caixa`.`movimento` = 0) and (`vw_itens_caixa`.`especie` = 0)) then (`vw_itens_caixa`.`valor` * -(1)) when ((`vw_itens_caixa`.`movimento` = 1) and (`vw_itens_caixa`.`especie` = 0)) then `vw_itens_caixa`.`valor` end) AS `valor_dh`,(case when ((`vw_itens_caixa`.`movimento` = 0) and (`vw_itens_caixa`.`especie` = 1)) then (`vw_itens_caixa`.`valor` * -(1)) when ((`vw_itens_caixa`.`movimento` = 1) and (`vw_itens_caixa`.`especie` = 1)) then `vw_itens_caixa`.`valor` end) AS `valor_ch`,(case when ((`vw_itens_caixa`.`movimento` = 0) and (`vw_itens_caixa`.`especie` = 2)) then (`vw_itens_caixa`.`valor` * -(1)) when ((`vw_itens_caixa`.`movimento` = 1) and (`vw_itens_caixa`.`especie` = 2)) then `vw_itens_caixa`.`valor` end) AS `valor_ct`,`vw_itens_caixa`.`data_inclusao` AS `data_inclusao`,`vw_itens_caixa`.`data_modificacao` AS `data_modificacao` from (`vw_itens_caixa` join `caixas` on((`vw_itens_caixa`.`id_caixa` = `caixas`.`id`))) order by `vw_itens_caixa`.`data` ;

-- --------------------------------------------------------

--
-- Structure for view `rep_clientes_geral`
--
DROP TABLE IF EXISTS `rep_clientes_geral`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_clientes_geral`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`doc_secundario` AS `doc_secundario`,(case `pessoas`.`tipo` when 0 then 'física' else 'jurídica' end) AS `tipo`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia`,`pessoas`.`estado_civil` AS `estado_civil`,`pessoas`.`pessoa_autorizada` AS `pessoa_autorizada`,(case when isnull(`pessoas`.`data_nascimento`) then '' else date_format(`pessoas`.`data_nascimento`,'%d/%m/%Y') end) AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito`,(case when isnull(`pessoas`.`cep_cidade_natal`) then '' else `pessoas`.`cep_cidade_natal` end) AS `cep_cidade_natal`,(case when isnull(`localidades`.`localidade`) then '' else `localidades`.`localidade` end) AS `localidade`,(case when isnull(`estados`.`nome_estado`) then '' else `estados`.`nome_estado` end) AS `estado`,`pessoas`.`data_inclusao` AS `data_inclusao`,`pessoas`.`data_modificacao` AS `data_modificacao` from ((`pessoas` left join `localidades` on((`pessoas`.`cep_cidade_natal` = `localidades`.`cep`))) left join `estados` on((`localidades`.`estado` = `estados`.`uf`))) where ((`pessoas`.`ativo` = 1) and (`pessoas`.`cliente` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_comissao`
--
DROP TABLE IF EXISTS `rep_comissao`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_comissao`  AS  select `vendas`.`data` AS `data`,cast(`vendas`.`data` as date) AS `data_pesquisa`,`vendas`.`id` AS `id_venda`,`vendas`.`nome_usuario` AS `nome_usuario`,`itens_vendas`.`id_produto` AS `id_produto`,`itens_vendas`.`quantidade` AS `quantidade`,`itens_vendas`.`valor_unitario` AS `valor_unitario`,(`itens_vendas`.`quantidade` * `itens_vendas`.`valor_unitario`) AS `valor_total`,`itens_vendas`.`comissao` AS `comissao`,((`itens_vendas`.`quantidade` * `itens_vendas`.`valor_unitario`) * (`itens_vendas`.`comissao` / 100)) AS `valor_comissao` from (`itens_vendas` join `vendas` on((`itens_vendas`.`id_venda` = `vendas`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_compras`
--
DROP TABLE IF EXISTS `rep_compras`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_compras`  AS  select `compras`.`id` AS `id`,`compras`.`data_nf_entrada` AS `data_nf_entrada`,cast(`compras`.`data_nf_entrada` as date) AS `data`,`compras`.`doc_principal_fornecedor` AS `doc_principal_fornecedor`,`pessoas`.`nome` AS `nome_fornecedor`,`compras`.`doc_principal_transportadora` AS `doc_principal_transportadora`,(select `pessoas`.`nome` from `pessoas` where (`pessoas`.`doc_principal` = `compras`.`doc_principal_transportadora`)) AS `nome_transportadora`,`compras`.`numero_nf_entrada` AS `numero_nf_entrada`,`compras`.`serie_nf_entrada` AS `serie_nf_entrada`,`compras`.`cfop` AS `cfop`,`compras`.`data_emissao_nf_entrada` AS `data_emissao_nf_entrada`,`compras`.`valor_frete` AS `valor_frete`,`compras`.`valor_total` AS `valor_total`,`compras`.`ipi_total` AS `ipi_total`,`compras`.`icms_st_total` AS `icms_st_total`,`compras`.`data_inclusao` AS `data_inclusao`,`compras`.`data_modificacao` AS `data_modificacao` from (`compras` join `pessoas` on((`pessoas`.`doc_principal` = `compras`.`doc_principal_fornecedor`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_contatos`
--
DROP TABLE IF EXISTS `rep_contatos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_contatos`  AS  select `contatos`.`id` AS `id`,`contatos`.`doc_principal_pessoa` AS `doc_principal_pessoa`,(case `contatos`.`tipo` when 0 then 'endereço' when 1 then 'telefone' else 'email' end) AS `tipo`,`contatos`.`descricao` AS `descricao`,(case when isnull(`localidades`.`localidade`) then '' else `localidades`.`localidade` end) AS `localidade`,(case when isnull(`estados`.`nome_estado`) then '' else `estados`.`nome_estado` end) AS `estado`,`contatos`.`data_inclusao` AS `data_inclusao`,`contatos`.`data_modificacao` AS `data_modificacao` from ((`contatos` left join `localidades` on((cast(right(`contatos`.`descricao`,8) as signed) = `localidades`.`cep`))) left join `estados` on((`localidades`.`estado` = `estados`.`uf`))) where (`contatos`.`padrao` = 1) order by `contatos`.`doc_principal_pessoa`,`contatos`.`tipo` ;

-- --------------------------------------------------------

--
-- Structure for view `rep_controle_ch_ct`
--
DROP TABLE IF EXISTS `rep_controle_ch_ct`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_controle_ch_ct`  AS  select `lancamentos_controle_cheque_cartao`.`id` AS `id`,`lancamentos_controle_cheque_cartao`.`numero_parcela` AS `numero_parcela`,`lancamentos_controle_cheque_cartao`.`id_controle_cheque_cartao` AS `id_controle_cheque_cartao`,`vw_controle_cheque_cartao_especie`.`doc_principal_pessoa` AS `doc_principal_pessoa`,`pessoas`.`nome` AS `nome`,`vw_controle_cheque_cartao_especie`.`dados_adicionais` AS `dados_adicionais`,`vw_controle_cheque_cartao_especie`.`valor_total` AS `valor_total`,`vw_controle_cheque_cartao_especie`.`quantidade_parcelas` AS `quantidade_parcelas`,(case `vw_controle_cheque_cartao_especie`.`especie` when 1 then 'cheque' else 'cartão' end) AS `especie`,`lancamentos_controle_cheque_cartao`.`valor_parcela` AS `valor_parcela`,`lancamentos_controle_cheque_cartao`.`data_vencimento` AS `data_vencimento`,`lancamentos_controle_cheque_cartao`.`data_pagamento` AS `data_pagamento`,`lancamentos_controle_cheque_cartao`.`data_inclusao` AS `data_inclusao`,`lancamentos_controle_cheque_cartao`.`data_modificacao` AS `data_modificacao` from ((`lancamentos_controle_cheque_cartao` join `vw_controle_cheque_cartao_especie` on((`lancamentos_controle_cheque_cartao`.`id_controle_cheque_cartao` = `vw_controle_cheque_cartao_especie`.`id`))) join `pessoas` on((`vw_controle_cheque_cartao_especie`.`doc_principal_pessoa` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_despesas`
--
DROP TABLE IF EXISTS `rep_despesas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_despesas`  AS  select `despesas_lancamentos_caixa`.`id` AS `id`,`despesas_lancamentos_caixa`.`descricao` AS `descricao`,`despesas_lancamentos_caixa`.`doc_principal_fornecedor` AS `doc_principal_fornecedor`,`pessoas`.`nome` AS `nome_fornecedor`,`itens_caixa`.`id_caixa` AS `id_caixa`,`despesas_lancamentos_caixa`.`id_item_caixa` AS `id_item_caixa`,`despesas_lancamentos_caixa`.`numero` AS `numero`,`despesas_lancamentos_caixa`.`valor` AS `valor`,`despesas_lancamentos_caixa`.`movimento` AS `movimento`,(case `despesas_lancamentos_caixa`.`movimento` when 0 then 'débito' else 'crédito' end) AS `desc_movimento`,(case `despesas_lancamentos_caixa`.`movimento` when 0 then `despesas_lancamentos_caixa`.`valor` else 0.000 end) AS `valor_debito`,(case `despesas_lancamentos_caixa`.`movimento` when 1 then `despesas_lancamentos_caixa`.`valor` else 0.000 end) AS `valor_credito`,(case `despesas_lancamentos_caixa`.`movimento` when 0 then (`despesas_lancamentos_caixa`.`valor` * -(1)) else `despesas_lancamentos_caixa`.`valor` end) AS `valor_movimento`,`despesas_lancamentos_caixa`.`data_vencimento` AS `data_vencimento`,`despesas_lancamentos_caixa`.`data_pagamento` AS `data_pagamento`,`despesas_lancamentos_caixa`.`data_inclusao` AS `data_inclusao`,`despesas_lancamentos_caixa`.`data_modificacao` AS `data_modificacao` from ((`despesas_lancamentos_caixa` left join `itens_caixa` on((`despesas_lancamentos_caixa`.`id_item_caixa` = `itens_caixa`.`id`))) join `pessoas` on((`despesas_lancamentos_caixa`.`doc_principal_fornecedor` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_fornecedores_geral`
--
DROP TABLE IF EXISTS `rep_fornecedores_geral`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_fornecedores_geral`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`doc_secundario` AS `doc_secundario`,(case `pessoas`.`tipo` when 0 then 'física' else 'jurídica' end) AS `tipo`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia`,`pessoas`.`estado_civil` AS `estado_civil`,`pessoas`.`pessoa_autorizada` AS `pessoa_autorizada`,`pessoas`.`data_nascimento` AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito`,`pessoas`.`cep_cidade_natal` AS `cep_cidade_natal`,`localidades`.`localidade` AS `localidade`,`estados`.`nome_estado` AS `estado`,`pessoas`.`data_inclusao` AS `data_inclusao`,`pessoas`.`data_modificacao` AS `data_modificacao` from ((`pessoas` left join `localidades` on((`pessoas`.`cep_cidade_natal` = `localidades`.`cep`))) left join `estados` on((`localidades`.`estado` = `estados`.`uf`))) where ((`pessoas`.`ativo` = 1) and (`pessoas`.`fornecedor` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_funcionarios_geral`
--
DROP TABLE IF EXISTS `rep_funcionarios_geral`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_funcionarios_geral`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`doc_secundario` AS `doc_secundario`,(case `pessoas`.`tipo` when 0 then 'física' else 'jurídica' end) AS `tipo`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia`,`pessoas`.`estado_civil` AS `estado_civil`,`pessoas`.`pessoa_autorizada` AS `pessoa_autorizada`,`pessoas`.`data_nascimento` AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito`,`pessoas`.`cep_cidade_natal` AS `cep_cidade_natal`,`localidades`.`localidade` AS `localidade`,`estados`.`nome_estado` AS `estado`,`pessoas`.`data_inclusao` AS `data_inclusao`,`pessoas`.`data_modificacao` AS `data_modificacao` from ((`pessoas` left join `localidades` on((`pessoas`.`cep_cidade_natal` = `localidades`.`cep`))) left join `estados` on((`localidades`.`estado` = `estados`.`uf`))) where ((`pessoas`.`ativo` = 1) and (`pessoas`.`funcionario` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_historico`
--
DROP TABLE IF EXISTS `rep_historico`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_historico`  AS  select `vw_historico`.`id` AS `id`,`vw_historico`.`nome_usuario` AS `nome_usuario`,`vw_historico`.`data` AS `data`,cast(`vw_historico`.`data` as date) AS `date_pesquisa`,`vw_historico`.`id_tarefa` AS `id_tarefa`,`vw_historico`.`descricao_tarefa` AS `descricao_tarefa`,`vw_historico`.`codigo` AS `codigo`,`vw_historico`.`descricao_historico` AS `descricao_historico` from `vw_historico` ;

-- --------------------------------------------------------

--
-- Structure for view `rep_itens_venda`
--
DROP TABLE IF EXISTS `rep_itens_venda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_itens_venda`  AS  select `itens_vendas`.`id` AS `id`,`itens_vendas`.`id_venda` AS `id_venda`,`itens_vendas`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome`,`itens_vendas`.`quantidade` AS `quantidade`,`itens_vendas`.`unidade` AS `unidade`,`itens_vendas`.`valor_unitario` AS `valor_unitario`,(`itens_vendas`.`valor_unitario` * `itens_vendas`.`quantidade`) AS `valor_total` from (`itens_vendas` join `produtos` on((`itens_vendas`.`id_produto` = `produtos`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_lancamentos_conta_pagar_fornecedor`
--
DROP TABLE IF EXISTS `rep_lancamentos_conta_pagar_fornecedor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_lancamentos_conta_pagar_fornecedor`  AS  select `lancamentos_conta_pagar`.`id` AS `id`,`lancamentos_conta_pagar`.`id_conta_pagar` AS `id_conta_pagar`,`lancamentos_conta_pagar`.`id_item_caixa` AS `id_item_caixa`,`contas_pagar`.`id_compra` AS `id_compra`,`contas_pagar`.`doc_principal_fornecedor` AS `doc_principal_fornecedor`,`pessoas`.`nome` AS `nome_fornecedor`,`lancamentos_conta_pagar`.`numero` AS `numero`,`lancamentos_conta_pagar`.`valor` AS `valor`,`lancamentos_conta_pagar`.`data_vencimento` AS `data_vencimento`,`lancamentos_conta_pagar`.`data_pagamento` AS `data_pagamento` from ((`lancamentos_conta_pagar` join `contas_pagar` on((`lancamentos_conta_pagar`.`id_conta_pagar` = `contas_pagar`.`id`))) join `pessoas` on((`contas_pagar`.`doc_principal_fornecedor` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_lancamentos_conta_receber`
--
DROP TABLE IF EXISTS `rep_lancamentos_conta_receber`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_lancamentos_conta_receber`  AS  select `lancamentos_conta_receber`.`id` AS `id`,`lancamentos_conta_receber`.`id_conta_receber` AS `id_conta_receber`,`lancamentos_conta_receber`.`id_item_caixa` AS `id_item_caixa`,`contas_receber`.`id_venda` AS `id_venda`,`lancamentos_conta_receber`.`valor` AS `valor`,`lancamentos_conta_receber`.`id_forma_pagamento` AS `id_forma_pagamento`,`formas_pagamento`.`descricao` AS `descricao`,(case `itens_caixa`.`especie` when 0 then 'dinheiro' when 1 then 'cheque' when 2 then 'cartão' else 'crediário' end) AS `especie`,`lancamentos_conta_receber`.`data_vencimento` AS `data_vencimento`,(case when isnull(`lancamentos_conta_receber`.`data_pagamento`) then '' else date_format(`lancamentos_conta_receber`.`data_pagamento`,'%d/%m/%Y') end) AS `data_pagamento` from (((`lancamentos_conta_receber` join `contas_receber` on((`lancamentos_conta_receber`.`id_conta_receber` = `contas_receber`.`id`))) join `formas_pagamento` on((`lancamentos_conta_receber`.`id_forma_pagamento` = `formas_pagamento`.`id`))) left join `itens_caixa` on((`lancamentos_conta_receber`.`id_item_caixa` = `itens_caixa`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_lancamentos_conta_receber_cliente`
--
DROP TABLE IF EXISTS `rep_lancamentos_conta_receber_cliente`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_lancamentos_conta_receber_cliente`  AS  select `lancamentos_conta_receber`.`id` AS `id`,`lancamentos_conta_receber`.`id_conta_receber` AS `id_conta_receber`,`lancamentos_conta_receber`.`id_item_caixa` AS `id_item_caixa`,`contas_receber`.`id_venda` AS `id_venda`,`contas_receber`.`doc_principal_cliente` AS `doc_principal_cliente`,`pessoas`.`nome` AS `nome_cliente`,`lancamentos_conta_receber`.`valor` AS `valor`,`lancamentos_conta_receber`.`id_forma_pagamento` AS `id_forma_pagamento`,`formas_pagamento`.`descricao` AS `descricao`,(case `itens_caixa`.`especie` when 0 then 'dinheiro' when 1 then 'cheque' when 2 then 'cartão' else 'crediário' end) AS `especie`,`lancamentos_conta_receber`.`data_vencimento` AS `data_vencimento`,cast(`lancamentos_conta_receber`.`data_pagamento` as date) AS `data_pagamento` from ((((`lancamentos_conta_receber` join `contas_receber` on((`lancamentos_conta_receber`.`id_conta_receber` = `contas_receber`.`id`))) join `formas_pagamento` on((`lancamentos_conta_receber`.`id_forma_pagamento` = `formas_pagamento`.`id`))) left join `itens_caixa` on((`lancamentos_conta_receber`.`id_item_caixa` = `itens_caixa`.`id`))) join `pessoas` on((`contas_receber`.`doc_principal_cliente` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_pessoas`
--
DROP TABLE IF EXISTS `rep_pessoas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_pessoas`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`doc_secundario` AS `doc_secundario`,(case `pessoas`.`tipo` when 0 then 'física' else 'jurídica' end) AS `tipo`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia`,`pessoas`.`estado_civil` AS `estado_civil`,`pessoas`.`pessoa_autorizada` AS `pessoa_autorizada`,(case when isnull(`pessoas`.`data_nascimento`) then '' else date_format(`pessoas`.`data_nascimento`,'%d/%m/%Y') end) AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito`,(case when isnull(`pessoas`.`cep_cidade_natal`) then '' else `pessoas`.`cep_cidade_natal` end) AS `cep_cidade_natal`,(case when isnull(`localidades`.`localidade`) then '' else `localidades`.`localidade` end) AS `localidade`,(case when isnull(`estados`.`nome_estado`) then '' else `estados`.`nome_estado` end) AS `estado`,`pessoas`.`data_inclusao` AS `data_inclusao`,`pessoas`.`data_modificacao` AS `data_modificacao` from ((`pessoas` left join `localidades` on((`pessoas`.`cep_cidade_natal` = `localidades`.`cep`))) left join `estados` on((`localidades`.`estado` = `estados`.`uf`))) where (`pessoas`.`ativo` = 1) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_producao_tinta`
--
DROP TABLE IF EXISTS `rep_producao_tinta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_producao_tinta`  AS  select `producao_tinta`.`id` AS `id`,`producao_tinta`.`data` AS `data`,`producao_tinta`.`id_tinta` AS `id_tinta`,`tintas`.`nome` AS `nome_tinta`,`tintas`.`cod_tinta` AS `codigo_tinta`,`producao_tinta`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome_produto`,`producao_tinta`.`id_embalagem` AS `id_embalagem`,(select `produtos`.`nome` from `produtos` where (`produtos`.`id` = `producao_tinta`.`id_embalagem`)) AS `descricao_embalagem`,`producao_tinta`.`quantidade` AS `quantidade`,`producao_tinta`.`unidade` AS `unidade`,`producao_tinta`.`valor_total` AS `valor_total` from ((`producao_tinta` join `produtos` on((`producao_tinta`.`id_produto` = `produtos`.`id`))) join `tintas` on((`producao_tinta`.`id_tinta` = `tintas`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_produtos`
--
DROP TABLE IF EXISTS `rep_produtos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_produtos`  AS  select `vw_produtos`.`id` AS `id`,`vw_produtos`.`nome` AS `nome`,`vw_produtos`.`codigo_barra` AS `codigo_barra`,`vw_produtos`.`codigo_fornecedor` AS `codigo_fornecedor`,`vw_produtos`.`id_categoria` AS `id_categoria`,`vw_produtos`.`categoria` AS `categoria`,`vw_produtos`.`id_marca` AS `id_marca`,`vw_produtos`.`marca` AS `marca`,`vw_produtos`.`estoque` AS `estoque`,`vw_produtos`.`sigla_unidade` AS `sigla_unidade`,`vw_produtos`.`quantidade_unitaria` AS `quantidade_unitaria`,`vw_produtos`.`quantidade_producao` AS `quantidade_producao`,`vw_produtos`.`unidade_producao` AS `unidade_producao`,`vw_produtos`.`fracionado` AS `fracionado`,(case `vw_produtos`.`fracionado` when 1 then 'sim' else 'não' end) AS `desc_fracionado`,`vw_produtos`.`preco_custo` AS `preco_custo`,`vw_produtos`.`ipi` AS `ipi`,`vw_produtos`.`icms_st` AS `icms_st`,`vw_produtos`.`diferenca_icms` AS `diferenca_icms`,`vw_produtos`.`frete` AS `frete`,((((`vw_produtos`.`preco_custo` + ((`vw_produtos`.`preco_custo` * `vw_produtos`.`ipi`) / 100)) + ((`vw_produtos`.`preco_custo` * `vw_produtos`.`icms_st`) / 100)) + ((`vw_produtos`.`preco_custo` * `vw_produtos`.`diferenca_icms`) / 100)) + ((`vw_produtos`.`preco_custo` * `vw_produtos`.`frete`) / 100)) AS `custo_final`,`vw_produtos`.`margem` AS `margem`,`vw_produtos`.`simples_nacional` AS `simples_nacional`,`vw_produtos`.`comissao` AS `comissao`,`vw_produtos`.`preco_venda` AS `preco_venda`,`vw_produtos`.`data_validade` AS `data_validade`,`vw_produtos`.`data_inclusao` AS `data_inclusao`,`vw_produtos`.`data_modificacao` AS `data_modificacao` from `vw_produtos` ;

-- --------------------------------------------------------

--
-- Structure for view `rep_usuarios`
--
DROP TABLE IF EXISTS `rep_usuarios`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_usuarios`  AS  select `vw_usuarios`.`nome` AS `nome`,(case `vw_usuarios`.`administrador` when 0 then 'não' else 'sim' end) AS `administrador`,`vw_usuarios`.`descricao_tipo` AS `descricao_tipo`,(case `usuarios`.`ativo` when 0 then 'não' else 'sim' end) AS `ativo` from (`vw_usuarios` join `usuarios` on((`vw_usuarios`.`nome` = `usuarios`.`nome`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_vendas`
--
DROP TABLE IF EXISTS `rep_vendas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_vendas`  AS  select `vendas`.`id` AS `id`,`vendas`.`data` AS `data`,`vendas`.`doc_principal_cliente` AS `doc_principal_cliente`,`pessoas`.`nome` AS `nome`,`vendas`.`nome_usuario` AS `nome_usuario` from (`vendas` join `pessoas` on((`vendas`.`doc_principal_cliente` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `rep_vendas_total`
--
DROP TABLE IF EXISTS `rep_vendas_total`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `rep_vendas_total`  AS  select `itens_vendas`.`id_venda` AS `id_venda`,`vendas`.`data` AS `data_completa`,cast(`vendas`.`data` as date) AS `data`,cast(`vendas`.`data` as time) AS `hora`,`vendas`.`doc_principal_cliente` AS `doc_principal_cliente`,`pessoas`.`nome` AS `nome_cliente`,`vendas`.`nome_usuario` AS `vendedor`,sum((`itens_vendas`.`quantidade` * `itens_vendas`.`valor_unitario`)) AS `valor_venda`,(select sum(`lancamentos_conta_receber`.`valor`) from (`lancamentos_conta_receber` join `contas_receber` on((`lancamentos_conta_receber`.`id_conta_receber` = `contas_receber`.`id`))) where (`contas_receber`.`id_venda` = `itens_vendas`.`id_venda`)) AS `valor_parcela` from ((`itens_vendas` join `vendas` on((`itens_vendas`.`id_venda` = `vendas`.`id`))) join `pessoas` on((`vendas`.`doc_principal_cliente` = `pessoas`.`doc_principal`))) where (`vendas`.`cancelada` = 0) group by `itens_vendas`.`id_venda` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_bases_tinta`
--
DROP TABLE IF EXISTS `vw_bases_tinta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_bases_tinta`  AS  select `bases_tinta`.`id` AS `id`,`bases_tinta`.`id_tinta` AS `id_tinta`,`bases_tinta`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome`,`bases_tinta`.`cod_base` AS `cod_base`,`bases_tinta`.`quantidade` AS `quantidade`,`bases_tinta`.`sigla_unidade` AS `sigla_unidade`,`bases_tinta`.`data_inclusao` AS `data_inclusao_base`,`bases_tinta`.`data_modificacao` AS `data_modificacao_base` from (`bases_tinta` join `produtos` on((`bases_tinta`.`id_produto` = `produtos`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_bases_tinta_producao`
--
DROP TABLE IF EXISTS `vw_bases_tinta_producao`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_bases_tinta_producao`  AS  select `vw_bases_tinta`.`id` AS `id`,`vw_bases_tinta`.`id_tinta` AS `id_tinta`,`vw_bases_tinta`.`id_produto` AS `id_produto`,`vw_bases_tinta`.`nome` AS `nome_base`,`vw_bases_tinta`.`cod_base` AS `cod_base`,`vw_bases_tinta`.`quantidade` AS `quantidade`,`vw_bases_tinta`.`sigla_unidade` AS `unidade_base_producao`,`produtos`.`quantidade_unitaria` AS `quant_unit_base_producao`,`produtos`.`sigla_unidade` AS `unid_quant_unitaria`,`produtos`.`quantidade_producao` AS `quantidade_producao`,`produtos`.`comissao` AS `comissao`,`produtos`.`simples_nacional` AS `simples_nacional`,`produtos`.`preco_custo` AS `preco_custo`,`produtos`.`preco_venda` AS `preco_venda`,(`produtos`.`quantidade_unitaria` / `produtos`.`quantidade_producao`) AS `razao_unidades`,`produtos`.`estoque` AS `estoque_atual`,`produtos`.`id_marca` AS `marca_produto`,`vw_bases_tinta`.`data_inclusao_base` AS `data_inclusao_base`,`vw_bases_tinta`.`data_modificacao_base` AS `data_modificacao_base` from (`vw_bases_tinta` join `produtos` on((`vw_bases_tinta`.`id_produto` = `produtos`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_caixa_consulta_conta_pagar`
--
DROP TABLE IF EXISTS `vw_caixa_consulta_conta_pagar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_caixa_consulta_conta_pagar`  AS  select `caixas`.`id` AS `id`,`caixas`.`descricao` AS `descricao`,`caixas`.`tipo` AS `tipo` from `caixas` where ((`caixas`.`tipo` = 1) and isnull(`caixas`.`data_fechamento`)) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_caixa_consulta_conta_receber`
--
DROP TABLE IF EXISTS `vw_caixa_consulta_conta_receber`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_caixa_consulta_conta_receber`  AS  select `caixas`.`id` AS `id`,`caixas`.`descricao` AS `descricao`,`caixas`.`tipo` AS `tipo` from `caixas` where isnull(`caixas`.`data_fechamento`) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_caixa_consulta_venda`
--
DROP TABLE IF EXISTS `vw_caixa_consulta_venda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_caixa_consulta_venda`  AS  select `caixas`.`id` AS `id`,`caixas`.`descricao` AS `descricao` from `caixas` where ((`caixas`.`tipo` = 0) and isnull(`caixas`.`data_fechamento`) and (cast(`caixas`.`data_abertura` as date) = cast(now() as date))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_caixa_tipo`
--
DROP TABLE IF EXISTS `vw_caixa_tipo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_caixa_tipo`  AS  select `caixas`.`id` AS `id`,`caixas`.`descricao` AS `descricao`,`caixas`.`tipo` AS `tipo`,(case `caixas`.`tipo` when 0 then 'normal' else 'cofre' end) AS `desc_tipo`,`caixas`.`data_abertura` AS `data_abertura`,`caixas`.`data_fechamento` AS `data_fechamento`,`caixas`.`saldo_final` AS `saldo_final`,`caixas`.`data_inclusao` AS `data_inclusao`,`caixas`.`data_modificacao` AS `data_modificacao` from `caixas` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_clientes_pesquisa_venda`
--
DROP TABLE IF EXISTS `vw_clientes_pesquisa_venda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_clientes_pesquisa_venda`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`nome` AS `nome`,`pessoas`.`data_nascimento` AS `data_nascimento`,`pessoas`.`limite_credito` AS `limite_credito` from `pessoas` where ((`pessoas`.`ativo` = 1) and (`pessoas`.`cliente` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_contas_pagar_pesquisa`
--
DROP TABLE IF EXISTS `vw_contas_pagar_pesquisa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_contas_pagar_pesquisa`  AS  select distinct `contas_pagar`.`doc_principal_fornecedor` AS `doc`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia` from (`contas_pagar` join `pessoas` on((`contas_pagar`.`doc_principal_fornecedor` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_contas_receber_pesquisa`
--
DROP TABLE IF EXISTS `vw_contas_receber_pesquisa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_contas_receber_pesquisa`  AS  select distinct `contas_receber`.`doc_principal_cliente` AS `doc`,`pessoas`.`nome` AS `nome`,`pessoas`.`fantasia` AS `fantasia` from (`contas_receber` join `pessoas` on((`contas_receber`.`doc_principal_cliente` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_controle_cheque_cartao_especie`
--
DROP TABLE IF EXISTS `vw_controle_cheque_cartao_especie`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_controle_cheque_cartao_especie`  AS  select distinct `controle_cheque_cartao`.`id` AS `id`,`controle_cheque_cartao`.`doc_principal_pessoa` AS `doc_principal_pessoa`,`pessoas`.`nome` AS `nome_pessoa`,`controle_cheque_cartao`.`id_conta_receber` AS `id_conta_receber`,`controle_cheque_cartao`.`dados_adicionais` AS `dados_adicionais`,`controle_cheque_cartao`.`valor_total` AS `valor_total`,`vw_itens_caixa`.`id` AS `id_item_caixa`,`vw_itens_caixa`.`especie` AS `especie`,`vw_itens_caixa`.`desc_especie` AS `desc_especie`,`controle_cheque_cartao`.`quantidade_parcelas` AS `quantidade_parcelas`,(select count(`lancamentos_controle_cheque_cartao`.`id`) from `lancamentos_controle_cheque_cartao` where ((`lancamentos_controle_cheque_cartao`.`id_controle_cheque_cartao` = `controle_cheque_cartao`.`id`) and isnull(`lancamentos_controle_cheque_cartao`.`data_pagamento`))) AS `quantidade_parcelas_abertas`,`controle_cheque_cartao`.`data_inclusao` AS `data_inclusao`,`controle_cheque_cartao`.`data_modificacao` AS `data_modificacao` from (((`controle_cheque_cartao` left join `lancamentos_conta_receber` on((`controle_cheque_cartao`.`id_conta_receber` = `lancamentos_conta_receber`.`id_conta_receber`))) left join `vw_itens_caixa` on((`lancamentos_conta_receber`.`id_item_caixa` = `vw_itens_caixa`.`id`))) join `pessoas` on((`controle_cheque_cartao`.`doc_principal_pessoa` = `pessoas`.`doc_principal`))) where (`vw_itens_caixa`.`especie` in (1,2)) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_controle_cheque_cartao_especie_aberto`
--
DROP TABLE IF EXISTS `vw_controle_cheque_cartao_especie_aberto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_controle_cheque_cartao_especie_aberto`  AS  select `vw_controle_cheque_cartao_especie`.`id` AS `id`,`vw_controle_cheque_cartao_especie`.`doc_principal_pessoa` AS `doc_principal_pessoa`,`vw_controle_cheque_cartao_especie`.`nome_pessoa` AS `nome_pessoa`,`vw_controle_cheque_cartao_especie`.`id_conta_receber` AS `id_conta_receber`,`vw_controle_cheque_cartao_especie`.`dados_adicionais` AS `dados_adicionais`,`vw_controle_cheque_cartao_especie`.`valor_total` AS `valor_total`,`vw_controle_cheque_cartao_especie`.`id_item_caixa` AS `id_item_caixa`,`vw_controle_cheque_cartao_especie`.`especie` AS `especie`,`vw_controle_cheque_cartao_especie`.`desc_especie` AS `desc_especie`,`vw_controle_cheque_cartao_especie`.`quantidade_parcelas` AS `quantidade_parcelas`,`vw_controle_cheque_cartao_especie`.`quantidade_parcelas_abertas` AS `quantidade_parcelas_abertas`,`vw_controle_cheque_cartao_especie`.`data_inclusao` AS `data_inclusao`,`vw_controle_cheque_cartao_especie`.`data_modificacao` AS `data_modificacao` from `vw_controle_cheque_cartao_especie` where (`vw_controle_cheque_cartao_especie`.`quantidade_parcelas_abertas` <> 0) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_formas_pagamento`
--
DROP TABLE IF EXISTS `vw_formas_pagamento`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_formas_pagamento`  AS  select `formas_pagamento`.`id` AS `id`,`formas_pagamento`.`descricao` AS `descricao`,`formas_pagamento`.`especie` AS `especie`,(case `formas_pagamento`.`especie` when 0 then 'dh' when 1 then 'ch' when 2 then 'ct' when 3 then 'crediário' end) AS `desc_especie`,`formas_pagamento`.`numero_parcelas` AS `numero_parcelas`,`formas_pagamento`.`prazo` AS `prazo`,`formas_pagamento`.`juros` AS `juros` from `formas_pagamento` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_formas_pagamento_finac`
--
DROP TABLE IF EXISTS `vw_formas_pagamento_finac`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_formas_pagamento_finac`  AS  select `formas_pagamento`.`id` AS `id`,`formas_pagamento`.`descricao` AS `descricao`,`formas_pagamento`.`especie` AS `especie`,(case `formas_pagamento`.`especie` when 0 then 'dh' when 1 then 'ch' when 2 then 'ct' when 3 then 'crediário' end) AS `desc_especie`,`formas_pagamento`.`numero_parcelas` AS `numero_parcelas`,`formas_pagamento`.`prazo` AS `prazo`,`formas_pagamento`.`juros` AS `juros`,`formas_pagamento`.`data_inclusao` AS `data_inclusao`,`formas_pagamento`.`data_modificacao` AS `data_modificacao` from `formas_pagamento` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_fornecedores_pesquisa_compra`
--
DROP TABLE IF EXISTS `vw_fornecedores_pesquisa_compra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_fornecedores_pesquisa_compra`  AS  select `pessoas`.`doc_principal` AS `doc_principal`,`pessoas`.`nome` AS `nome` from `pessoas` where ((`pessoas`.`ativo` = 1) and (`pessoas`.`fornecedor` = 1)) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_historico`
--
DROP TABLE IF EXISTS `vw_historico`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_historico`  AS  select `historico`.`id` AS `id`,`historico`.`nome_usuario` AS `nome_usuario`,`historico`.`data` AS `data`,`historico`.`id_tarefa` AS `id_tarefa`,`tarefas`.`descricao` AS `descricao_tarefa`,`historico`.`codigo` AS `codigo`,`historico`.`descricao` AS `descricao_historico` from (`historico` join `tarefas` on((`historico`.`id_tarefa` = `tarefas`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_itens_caixa`
--
DROP TABLE IF EXISTS `vw_itens_caixa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_itens_caixa`  AS  select `itens_caixa`.`id` AS `id`,`itens_caixa`.`id_caixa` AS `id_caixa`,`itens_caixa`.`data` AS `data`,`itens_caixa`.`descricao` AS `descricao`,`itens_caixa`.`valor` AS `valor`,`itens_caixa`.`movimento` AS `movimento`,(case `itens_caixa`.`movimento` when 1 then `itens_caixa`.`valor` end) AS `credito`,(case `itens_caixa`.`movimento` when 0 then `itens_caixa`.`valor` end) AS `debito`,`itens_caixa`.`especie` AS `especie`,(case `itens_caixa`.`especie` when 0 then 'dinheiro' when 1 then 'cheque' when 2 then 'cartão' end) AS `desc_especie`,`itens_caixa`.`data_inclusao` AS `data_inclusao`,`itens_caixa`.`data_modificacao` AS `data_modificacao` from `itens_caixa` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_itens_compras`
--
DROP TABLE IF EXISTS `vw_itens_compras`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_itens_compras`  AS  select `itens_compras`.`id` AS `id`,`itens_compras`.`id_compra` AS `id_compra`,`itens_compras`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome_produto`,`itens_compras`.`quantidade` AS `quantidade`,`itens_compras`.`valor_custo_unitario` AS `valor_custo_unitario`,`itens_compras`.`ipi` AS `ipi`,`itens_compras`.`diferenca_icms` AS `diferenca_icms`,`itens_compras`.`icms_st` AS `icms_st`,`itens_compras`.`frete` AS `frete`,`itens_compras`.`data_vencimento_produto` AS `data_vencimento_produto` from (`itens_compras` join `produtos` on((`itens_compras`.`id_produto` = `produtos`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_itens_vendas`
--
DROP TABLE IF EXISTS `vw_itens_vendas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_itens_vendas`  AS  select `itens_vendas`.`id` AS `id`,`itens_vendas`.`id_venda` AS `id_venda`,`itens_vendas`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome_produto`,`itens_vendas`.`quantidade` AS `quantidade`,`itens_vendas`.`unidade` AS `unidade`,`itens_vendas`.`valor_unitario` AS `valor_unitario`,(`itens_vendas`.`valor_unitario` * `itens_vendas`.`quantidade`) AS `total`,`itens_vendas`.`comissao` AS `comissao`,`itens_vendas`.`data_inclusao` AS `data_inclusao`,`itens_vendas`.`data_modificacao` AS `data_modificacao` from (`itens_vendas` join `produtos` on((`produtos`.`id` = `itens_vendas`.`id_produto`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_itens_vendas_porcentagens`
--
DROP TABLE IF EXISTS `vw_itens_vendas_porcentagens`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_itens_vendas_porcentagens`  AS  select `itens_vendas`.`id_venda` AS `id_venda`,`vendas`.`data` AS `data`,`itens_vendas`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome`,`itens_vendas`.`quantidade` AS `quantidade`,`produtos`.`sigla_unidade` AS `sigla_unidade`,`itens_vendas`.`valor_unitario` AS `valor_unitario`,(`itens_vendas`.`quantidade` * `itens_vendas`.`valor_unitario`) AS `valor_total`,`produtos`.`comissao` AS `comissao`,`produtos`.`simples_nacional` AS `simples_nacional`,`produtos`.`margem` AS `margem`,(`produtos`.`preco_custo` * `itens_vendas`.`quantidade`) AS `valor_custo_total` from ((`itens_vendas` join `vendas` on((`itens_vendas`.`id_venda` = `vendas`.`id`))) join `produtos` on((`itens_vendas`.`id_produto` = `produtos`.`id`))) where (`vendas`.`cancelada` = 0) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_lancamentos_conta_pagar_pessoa`
--
DROP TABLE IF EXISTS `vw_lancamentos_conta_pagar_pessoa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_lancamentos_conta_pagar_pessoa`  AS  select `lancamentos_conta_pagar`.`id` AS `id`,`lancamentos_conta_pagar`.`id_conta_pagar` AS `id_conta_pagar`,`contas_pagar`.`doc_principal_fornecedor` AS `doc_principal_fornecedor`,`contas_pagar`.`id_compra` AS `id_compra`,`lancamentos_conta_pagar`.`id_item_caixa` AS `id_item_caixa`,`lancamentos_conta_pagar`.`valor` AS `valor`,`lancamentos_conta_pagar`.`data_vencimento` AS `data_vencimento`,`lancamentos_conta_pagar`.`data_pagamento` AS `data_pagamento`,`lancamentos_conta_pagar`.`data_inclusao` AS `data_inclusao`,`lancamentos_conta_pagar`.`data_modificacao` AS `data_modificacao` from (`lancamentos_conta_pagar` join `contas_pagar` on((`lancamentos_conta_pagar`.`id_conta_pagar` = `contas_pagar`.`id`))) order by `lancamentos_conta_pagar`.`data_vencimento` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_lancamentos_conta_receber`
--
DROP TABLE IF EXISTS `vw_lancamentos_conta_receber`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_lancamentos_conta_receber`  AS  select `lancamentos_conta_receber`.`id` AS `id`,`lancamentos_conta_receber`.`id_conta_receber` AS `id_conta_receber`,`lancamentos_conta_receber`.`id_item_caixa` AS `id_item_caixa`,`lancamentos_conta_receber`.`valor` AS `valor`,`lancamentos_conta_receber`.`id_forma_pagamento` AS `id_forma_pagamento`,`formas_pagamento`.`descricao` AS `descricao`,(case `formas_pagamento`.`especie` when 0 then 'dh' when 1 then 'ch' when 2 then 'ct' when 3 then 'crediário' end) AS `desc_especie`,`lancamentos_conta_receber`.`data_vencimento` AS `data_vencimento`,`lancamentos_conta_receber`.`data_pagamento` AS `data_pagamento` from (`lancamentos_conta_receber` join `formas_pagamento` on((`lancamentos_conta_receber`.`id_forma_pagamento` = `formas_pagamento`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_lancamentos_conta_receber_pessoa`
--
DROP TABLE IF EXISTS `vw_lancamentos_conta_receber_pessoa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_lancamentos_conta_receber_pessoa`  AS  select `lancamentos_conta_receber`.`id` AS `id`,`lancamentos_conta_receber`.`id_conta_receber` AS `id_conta_receber`,`contas_receber`.`doc_principal_cliente` AS `doc_principal_cliente`,`contas_receber`.`id_venda` AS `id_venda`,`lancamentos_conta_receber`.`id_item_caixa` AS `id_item_caixa`,`lancamentos_conta_receber`.`valor` AS `valor`,`lancamentos_conta_receber`.`id_forma_pagamento` AS `id_forma_pagamento`,`lancamentos_conta_receber`.`data_vencimento` AS `data_vencimento`,`lancamentos_conta_receber`.`data_pagamento` AS `data_pagamento`,`lancamentos_conta_receber`.`data_inclusao` AS `data_inclusao`,`lancamentos_conta_receber`.`data_modificacao` AS `data_modificacao` from (`lancamentos_conta_receber` join `contas_receber` on((`lancamentos_conta_receber`.`id_conta_receber` = `contas_receber`.`id`))) order by `lancamentos_conta_receber`.`data_vencimento` ;

-- --------------------------------------------------------

--
-- Structure for view `vw_marcas`
--
DROP TABLE IF EXISTS `vw_marcas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY INVOKER VIEW `vw_marcas`  AS  select `marcas`.`id` AS `id`,`marcas`.`descricao` AS `descricao`,`marcas`.`doc_principal_fornecedor` AS `doc_principal_fornecedor`,`pessoas`.`nome` AS `nome_fornecedor`,`marcas`.`data_inclusao` AS `data_inclusao`,`marcas`.`data_modificacao` AS `data_modificacao` from (`marcas` join `pessoas` on((`marcas`.`doc_principal_fornecedor` = `pessoas`.`doc_principal`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_produtos`
--
DROP TABLE IF EXISTS `vw_produtos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_produtos`  AS  select `produtos`.`id` AS `id`,`produtos`.`nome` AS `nome`,`produtos`.`codigo_barra` AS `codigo_barra`,`produtos`.`codigo_fornecedor` AS `codigo_fornecedor`,`produtos`.`id_categoria` AS `id_categoria`,`categorias_produto`.`descricao` AS `categoria`,`produtos`.`id_marca` AS `id_marca`,`marcas`.`descricao` AS `marca`,`produtos`.`estoque` AS `estoque`,`produtos`.`sigla_unidade` AS `sigla_unidade`,`produtos`.`quantidade_unitaria` AS `quantidade_unitaria`,`produtos`.`quantidade_producao` AS `quantidade_producao`,`produtos`.`unidade_producao` AS `unidade_producao`,`produtos`.`fracionado` AS `fracionado`,`produtos`.`preco_custo` AS `preco_custo`,`produtos`.`ipi` AS `ipi`,`produtos`.`icms_st` AS `icms_st`,`produtos`.`diferenca_icms` AS `diferenca_icms`,`produtos`.`simples_nacional` AS `simples_nacional`,`produtos`.`frete` AS `frete`,`produtos`.`margem` AS `margem`,`produtos`.`preco_venda` AS `preco_venda`,`produtos`.`comissao` AS `comissao`,`produtos`.`data_validade` AS `data_validade`,`produtos`.`data_inclusao` AS `data_inclusao`,`produtos`.`data_modificacao` AS `data_modificacao` from ((`produtos` join `categorias_produto` on((`categorias_produto`.`id` = `produtos`.`id_categoria`))) join `marcas` on((`marcas`.`id` = `produtos`.`id_marca`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_produtos_base_tinta`
--
DROP TABLE IF EXISTS `vw_produtos_base_tinta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_produtos_base_tinta`  AS  select `vw_produtos`.`id` AS `id`,`vw_produtos`.`nome` AS `nome`,`vw_produtos`.`codigo_fornecedor` AS `codigo_fornecedor`,`vw_produtos`.`unidade_producao` AS `unidade_producao` from `vw_produtos` where (`vw_produtos`.`id_categoria` = 1) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_promocoes`
--
DROP TABLE IF EXISTS `vw_promocoes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_promocoes`  AS  select `promocoes`.`id` AS `id`,`promocoes`.`id_produto` AS `id_produto`,`produtos`.`nome` AS `nome`,`produtos`.`codigo_barra` AS `codigo_barra`,`produtos`.`codigo_fornecedor` AS `codigo_fornecedor`,`promocoes`.`valor_unitario` AS `valor_unitario`,`promocoes`.`quantidade` AS `quantidade`,`produtos`.`preco_venda` AS `valor_original`,`promocoes`.`data_inicio` AS `data_inicio`,`promocoes`.`data_fim` AS `data_fim`,`promocoes`.`data_inclusao` AS `data_inclusao`,`promocoes`.`data_modificacao` AS `data_modificacao` from (`promocoes` join `produtos` on((`promocoes`.`id_produto` = `produtos`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_promocoes_ativas`
--
DROP TABLE IF EXISTS `vw_promocoes_ativas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_promocoes_ativas`  AS  select `vw_promocoes`.`id` AS `id`,`vw_promocoes`.`id_produto` AS `id_produto`,`vw_promocoes`.`nome` AS `nome`,`vw_promocoes`.`codigo_barra` AS `codigo_barra`,`vw_promocoes`.`codigo_fornecedor` AS `codigo_fornecedor`,`vw_promocoes`.`valor_unitario` AS `valor_unitario`,`vw_promocoes`.`quantidade` AS `quantidade`,`vw_promocoes`.`valor_original` AS `valor_original`,`vw_promocoes`.`data_inicio` AS `data_inicio`,`vw_promocoes`.`data_fim` AS `data_fim`,`vw_promocoes`.`data_inclusao` AS `data_inclusao`,`vw_promocoes`.`data_modificacao` AS `data_modificacao` from `vw_promocoes` where ((`vw_promocoes`.`data_inicio` <= now()) and (isnull(`vw_promocoes`.`data_fim`) or (`vw_promocoes`.`data_fim` >= now()))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_tarefas_tipo_usuario`
--
DROP TABLE IF EXISTS `vw_tarefas_tipo_usuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_tarefas_tipo_usuario`  AS  select `tarefas_tipo_usuario`.`id` AS `id`,`tarefas_tipo_usuario`.`id_tipo_usuario` AS `id_tipo_usuario`,`tipos_usuario`.`descricao` AS `descricao_tipo_usuario`,`tarefas_tipo_usuario`.`id_tarefa` AS `id_tarefa`,`tarefas`.`nome` AS `nome_tarefa`,`tarefas`.`descricao` AS `descricao_tarefa`,`tarefas_tipo_usuario`.`acesso` AS `acesso`,(case `tarefas_tipo_usuario`.`acesso` when 1 then 'sim' else 'não' end) AS `acesso_desc`,`tarefas_tipo_usuario`.`gravacao` AS `gravacao`,(case `tarefas_tipo_usuario`.`gravacao` when 1 then 'sim' else 'não' end) AS `gravacao_desc`,`tarefas_tipo_usuario`.`remocao` AS `remocao`,(case `tarefas_tipo_usuario`.`remocao` when 1 then 'sim' else 'não' end) AS `remocao_desc`,`tarefas_tipo_usuario`.`data_inclusao` AS `data_inclusao`,`tarefas_tipo_usuario`.`data_modificacao` AS `data_modificacao` from ((`tarefas_tipo_usuario` join `tipos_usuario` on((`tarefas_tipo_usuario`.`id_tipo_usuario` = `tipos_usuario`.`id`))) join `tarefas` on((`tarefas_tipo_usuario`.`id_tarefa` = `tarefas`.`id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_tintas`
--
DROP TABLE IF EXISTS `vw_tintas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_tintas`  AS  select `tintas`.`id` AS `id`,`tintas`.`nome` AS `nome`,`tintas`.`cod_tinta` AS `cod_tinta`,`tintas`.`ano_inicial` AS `ano_inicial`,`tintas`.`ano_final` AS `ano_final`,`tintas`.`id_categoria_tinta` AS `id_categoria_tinta`,`categorias_tinta`.`descricao` AS `categoria`,`tintas`.`id_tipo_tinta` AS `id_tipo_tinta`,`tipos_tinta`.`descricao` AS `tipo`,`tintas`.`sigla_montadora` AS `sigla_montadora`,`montadoras`.`descricao` AS `montadora`,`tintas`.`quantidade_producao` AS `quantidade_producao`,`tintas`.`quantidade_minima` AS `quantidade_minima`,`tintas`.`sigla_unidade` AS `sigla_unidade`,`unidades`.`descricao` AS `unidade`,`tintas`.`data_inclusao` AS `data_inclusao`,`tintas`.`data_modificacao` AS `data_modificacao` from ((((`tintas` join `categorias_tinta` on((`tintas`.`id_categoria_tinta` = `categorias_tinta`.`id`))) join `tipos_tinta` on((`tintas`.`id_tipo_tinta` = `tipos_tinta`.`id`))) join `montadoras` on((`tintas`.`sigla_montadora` = `montadoras`.`sigla`))) join `unidades` on((`tintas`.`sigla_unidade` = `unidades`.`sigla`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_usuarios`
--
DROP TABLE IF EXISTS `vw_usuarios`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_usuarios`  AS  select `usuarios`.`nome` AS `nome`,`usuarios`.`senha` AS `senha`,`usuarios`.`administrador` AS `administrador`,`usuarios`.`tipo` AS `tipo`,`tipos_usuario`.`descricao` AS `descricao_tipo` from (`usuarios` left join `tipos_usuario` on((`usuarios`.`tipo` = `tipos_usuario`.`id`))) where (`usuarios`.`ativo` = 1) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_usuarios_pesquisa_historico`
--
DROP TABLE IF EXISTS `vw_usuarios_pesquisa_historico`;

CREATE ALGORITHM=UNDEFINED DEFINER=`orions`@`localhost` SQL SECURITY DEFINER VIEW `vw_usuarios_pesquisa_historico`  AS  select `usuarios`.`nome` AS `nome_usuario`,`pessoas`.`nome` AS `nome_pessoa`,(case `usuarios`.`administrador` when 1 then 'sim' else 'não' end) AS `administrador`,`tipos_usuario`.`descricao` AS `desc_tipo`,(case `usuarios`.`ativo` when 1 then 'sim' else 'não' end) AS `ativo` from ((`usuarios` join `pessoas` on((`usuarios`.`doc_principal_funcionario` = `pessoas`.`doc_principal`))) left join `tipos_usuario` on((`usuarios`.`tipo` = `tipos_usuario`.`id`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bases_tinta`
--
ALTER TABLE `bases_tinta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bases_tinta_tintas1_idx` (`id_tinta`),
  ADD KEY `fk_bases_tinta_produtos1_idx` (`id_produto`),
  ADD KEY `fk_bases_tinta_unidades1_idx` (`sigla_unidade`);

--
-- Indexes for table `caixas`
--
ALTER TABLE `caixas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categorias_produto`
--
ALTER TABLE `categorias_produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descricao` (`descricao`);

--
-- Indexes for table `categorias_tinta`
--
ALTER TABLE `categorias_tinta`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cfop`
--
ALTER TABLE `cfop`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_compras_cfop1_idx` (`cfop`),
  ADD KEY `fk_compras_pessoas1_idx` (`doc_principal_fornecedor`),
  ADD KEY `fk_compras_pessoas2_idx` (`doc_principal_transportadora`);

--
-- Indexes for table `configuracoes`
--
ALTER TABLE `configuracoes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contas_pagar`
--
ALTER TABLE `contas_pagar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_contas_pagar_pessoas1_idx` (`doc_principal_fornecedor`),
  ADD KEY `fk_contas_pagar_compras1_idx` (`id_compra`);

--
-- Indexes for table `contas_receber`
--
ALTER TABLE `contas_receber`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_contas_receber_pessoas1_idx` (`doc_principal_cliente`),
  ADD KEY `fk_contas_receber_vendas1_idx` (`id_venda`);

--
-- Indexes for table `contatos`
--
ALTER TABLE `contatos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_contatos_pessoas1_idx` (`doc_principal_pessoa`);

--
-- Indexes for table `controle_cheque_cartao`
--
ALTER TABLE `controle_cheque_cartao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_controle_cheque_cartao_pessoas1_idx` (`doc_principal_pessoa`),
  ADD KEY `fk_controle_cheque_cartao_contas_receber1_idx` (`id_conta_receber`);

--
-- Indexes for table `despesas_lancamentos_caixa`
--
ALTER TABLE `despesas_lancamentos_caixa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doc_principal_fornecedor` (`doc_principal_fornecedor`),
  ADD KEY `id_item_caixa` (`id_item_caixa`);

--
-- Indexes for table `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`uf`);

--
-- Indexes for table `formas_pagamento`
--
ALTER TABLE `formas_pagamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_historico_usuarios1_idx` (`nome_usuario`),
  ADD KEY `id_tarefa` (`id_tarefa`);

--
-- Indexes for table `itens_caixa`
--
ALTER TABLE `itens_caixa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_itens_caixa_caixas1_idx` (`id_caixa`);

--
-- Indexes for table `itens_compras`
--
ALTER TABLE `itens_compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_itens_compras_compras1_idx` (`id_compra`),
  ADD KEY `fk_itens_compras_produtos1_idx` (`id_produto`);

--
-- Indexes for table `itens_vendas`
--
ALTER TABLE `itens_vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_itens_vendas_vendas1_idx` (`id_venda`),
  ADD KEY `fk_itens_vendas_produtos1_idx` (`id_produto`);

--
-- Indexes for table `lancamentos_conta_pagar`
--
ALTER TABLE `lancamentos_conta_pagar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lancamentos_conta_pagar_contas_pagar1_idx` (`id_conta_pagar`),
  ADD KEY `fk_lancamentos_conta_pagar_itens_caixa1_idx` (`id_item_caixa`);

--
-- Indexes for table `lancamentos_conta_receber`
--
ALTER TABLE `lancamentos_conta_receber`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lancamentos_conta_receber_contas_receber1_idx` (`id_conta_receber`),
  ADD KEY `fk_lancamentos_conta_receber_itens_caixa1_idx` (`id_item_caixa`),
  ADD KEY `fk_lancamentos_conta_receber_formas_pagamento1_idx` (`id_forma_pagamento`);

--
-- Indexes for table `lancamentos_controle_cheque_cartao`
--
ALTER TABLE `lancamentos_controle_cheque_cartao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lancamentos_controle_cheque_cartao_controle_cheque_carta_idx` (`id_controle_cheque_cartao`);

--
-- Indexes for table `localidades`
--
ALTER TABLE `localidades`
  ADD PRIMARY KEY (`cep`);

--
-- Indexes for table `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_marcas_pessoas1_idx` (`doc_principal_fornecedor`);

--
-- Indexes for table `montadoras`
--
ALTER TABLE `montadoras`
  ADD PRIMARY KEY (`sigla`);

--
-- Indexes for table `pessoas`
--
ALTER TABLE `pessoas`
  ADD PRIMARY KEY (`doc_principal`),
  ADD KEY `fk_pessoas_localidades1_idx` (`cep_cidade_natal`);

--
-- Indexes for table `producao_tinta`
--
ALTER TABLE `producao_tinta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_producao_tinta_tintas1_idx` (`id_tinta`),
  ADD KEY `fk_producao_tinta_produto` (`id_produto`),
  ADD KEY `id_embalagem_producao` (`id_embalagem`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`),
  ADD KEY `fk_produtos_categorias_produto1_idx` (`id_categoria`),
  ADD KEY `fk_produtos_marcas1_idx` (`id_marca`),
  ADD KEY `fk_produtos_unidades1_idx` (`sigla_unidade`),
  ADD KEY `unidade_producao` (`unidade_producao`);

--
-- Indexes for table `promocoes`
--
ALTER TABLE `promocoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_promocoes_produtos1_idx` (`id_produto`);

--
-- Indexes for table `tarefas`
--
ALTER TABLE `tarefas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indexes for table `tarefas_tipo_usuario`
--
ALTER TABLE `tarefas_tipo_usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo_usuario` (`id_tipo_usuario`),
  ADD KEY `id_tarefa` (`id_tarefa`);

--
-- Indexes for table `tintas`
--
ALTER TABLE `tintas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tintas_tipos_tinta1_idx` (`id_tipo_tinta`),
  ADD KEY `fk_tintas_categorias_tinta1_idx` (`id_categoria_tinta`),
  ADD KEY `fk_tintas_montadoras1_idx` (`sigla_montadora`),
  ADD KEY `fk_tintas_unidades1_idx` (`sigla_unidade`);

--
-- Indexes for table `tipos_tinta`
--
ALTER TABLE `tipos_tinta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descricao` (`descricao`);

--
-- Indexes for table `tipos_usuario`
--
ALTER TABLE `tipos_usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descricao` (`descricao`);

--
-- Indexes for table `unidades`
--
ALTER TABLE `unidades`
  ADD PRIMARY KEY (`sigla`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nome`),
  ADD KEY `fk_usuarios_tipos_usuario1_idx1` (`tipo`),
  ADD KEY `fk_usuarios_pessoas1_idx` (`doc_principal_funcionario`);

--
-- Indexes for table `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_vendas_pessoas1_idx` (`doc_principal_cliente`),
  ADD KEY `fk_vendas_usuarios1_idx` (`nome_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bases_tinta`
--
ALTER TABLE `bases_tinta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `caixas`
--
ALTER TABLE `caixas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `categorias_produto`
--
ALTER TABLE `categorias_produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `categorias_tinta`
--
ALTER TABLE `categorias_tinta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `cfop`
--
ALTER TABLE `cfop`
  MODIFY `codigo` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7950;
--
-- AUTO_INCREMENT for table `compras`
--
ALTER TABLE `compras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `configuracoes`
--
ALTER TABLE `configuracoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `contas_pagar`
--
ALTER TABLE `contas_pagar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT for table `contas_receber`
--
ALTER TABLE `contas_receber`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `contatos`
--
ALTER TABLE `contatos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `controle_cheque_cartao`
--
ALTER TABLE `controle_cheque_cartao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `despesas_lancamentos_caixa`
--
ALTER TABLE `despesas_lancamentos_caixa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `formas_pagamento`
--
ALTER TABLE `formas_pagamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `historico`
--
ALTER TABLE `historico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `itens_caixa`
--
ALTER TABLE `itens_caixa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=192;
--
-- AUTO_INCREMENT for table `itens_compras`
--
ALTER TABLE `itens_compras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `itens_vendas`
--
ALTER TABLE `itens_vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `lancamentos_conta_pagar`
--
ALTER TABLE `lancamentos_conta_pagar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lancamentos_conta_receber`
--
ALTER TABLE `lancamentos_conta_receber`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lancamentos_controle_cheque_cartao`
--
ALTER TABLE `lancamentos_controle_cheque_cartao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `producao_tinta`
--
ALTER TABLE `producao_tinta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `promocoes`
--
ALTER TABLE `promocoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tarefas`
--
ALTER TABLE `tarefas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `tarefas_tipo_usuario`
--
ALTER TABLE `tarefas_tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT for table `tintas`
--
ALTER TABLE `tintas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tipos_tinta`
--
ALTER TABLE `tipos_tinta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tipos_usuario`
--
ALTER TABLE `tipos_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bases_tinta`
--
ALTER TABLE `bases_tinta`
  ADD CONSTRAINT `fk_bases_tinta_produtos1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_bases_tinta_tintas1` FOREIGN KEY (`id_tinta`) REFERENCES `tintas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_bases_tinta_unidades1` FOREIGN KEY (`sigla_unidade`) REFERENCES `unidades` (`sigla`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `fk_compras_cfop1` FOREIGN KEY (`cfop`) REFERENCES `cfop` (`codigo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_compras_pessoas1` FOREIGN KEY (`doc_principal_fornecedor`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_compras_pessoas2` FOREIGN KEY (`doc_principal_transportadora`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `contas_pagar`
--
ALTER TABLE `contas_pagar`
  ADD CONSTRAINT `fk_contas_pagar_compras1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_contas_pagar_pessoas1` FOREIGN KEY (`doc_principal_fornecedor`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `contas_receber`
--
ALTER TABLE `contas_receber`
  ADD CONSTRAINT `fk_contas_receber_pessoas1` FOREIGN KEY (`doc_principal_cliente`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_contas_receber_vendas1` FOREIGN KEY (`id_venda`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `contatos`
--
ALTER TABLE `contatos`
  ADD CONSTRAINT `fk_contatos_pessoas1` FOREIGN KEY (`doc_principal_pessoa`) REFERENCES `pessoas` (`doc_principal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `controle_cheque_cartao`
--
ALTER TABLE `controle_cheque_cartao`
  ADD CONSTRAINT `fk_controle_cheque_cartao_contas_receber1` FOREIGN KEY (`id_conta_receber`) REFERENCES `contas_receber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_controle_cheque_cartao_pessoas1` FOREIGN KEY (`doc_principal_pessoa`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `despesas_lancamentos_caixa`
--
ALTER TABLE `despesas_lancamentos_caixa`
  ADD CONSTRAINT `fk_doc_principal_fornecedor` FOREIGN KEY (`doc_principal_fornecedor`) REFERENCES `pessoas` (`doc_principal`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_item_caixa` FOREIGN KEY (`id_item_caixa`) REFERENCES `itens_caixa` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `fk_historico_tarefa_1` FOREIGN KEY (`id_tarefa`) REFERENCES `tarefas` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_historico_usuarios1` FOREIGN KEY (`nome_usuario`) REFERENCES `usuarios` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `itens_caixa`
--
ALTER TABLE `itens_caixa`
  ADD CONSTRAINT `fk_itens_caixa_caixas1` FOREIGN KEY (`id_caixa`) REFERENCES `caixas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `itens_compras`
--
ALTER TABLE `itens_compras`
  ADD CONSTRAINT `fk_itens_compras_compras1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_itens_compras_produtos1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `itens_vendas`
--
ALTER TABLE `itens_vendas`
  ADD CONSTRAINT `fk_itens_vendas_produtos1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_itens_vendas_vendas1` FOREIGN KEY (`id_venda`) REFERENCES `vendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lancamentos_conta_pagar`
--
ALTER TABLE `lancamentos_conta_pagar`
  ADD CONSTRAINT `fk_lancamentos_conta_pagar_contas_pagar1` FOREIGN KEY (`id_conta_pagar`) REFERENCES `contas_pagar` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_lancamentos_conta_pagar_itens_caixa1` FOREIGN KEY (`id_item_caixa`) REFERENCES `itens_caixa` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `lancamentos_conta_receber`
--
ALTER TABLE `lancamentos_conta_receber`
  ADD CONSTRAINT `fk_lancamentos_conta_receber_contas_receber1` FOREIGN KEY (`id_conta_receber`) REFERENCES `contas_receber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_lancamentos_conta_receber_formas_pagamento1` FOREIGN KEY (`id_forma_pagamento`) REFERENCES `formas_pagamento` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_lancamentos_conta_receber_itens_caixa1` FOREIGN KEY (`id_item_caixa`) REFERENCES `itens_caixa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lancamentos_controle_cheque_cartao`
--
ALTER TABLE `lancamentos_controle_cheque_cartao`
  ADD CONSTRAINT `fk_lancamentos_controle_cheque_cartao_controle_cheque_cartao1` FOREIGN KEY (`id_controle_cheque_cartao`) REFERENCES `controle_cheque_cartao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `marcas`
--
ALTER TABLE `marcas`
  ADD CONSTRAINT `fk_marcas_pessoas1` FOREIGN KEY (`doc_principal_fornecedor`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `pessoas`
--
ALTER TABLE `pessoas`
  ADD CONSTRAINT `fk_pessoas_localidades1` FOREIGN KEY (`cep_cidade_natal`) REFERENCES `localidades` (`cep`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `producao_tinta`
--
ALTER TABLE `producao_tinta`
  ADD CONSTRAINT `fh_producao_tinta_produto1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_producao_embalagem` FOREIGN KEY (`id_embalagem`) REFERENCES `produtos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_producao_tinta_tintas1` FOREIGN KEY (`id_tinta`) REFERENCES `tintas` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `fk_produtos_categorias_produto1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias_produto` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produtos_marcas1` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produtos_unidades1` FOREIGN KEY (`sigla_unidade`) REFERENCES `unidades` (`sigla`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produtos_unidades2` FOREIGN KEY (`unidade_producao`) REFERENCES `unidades` (`sigla`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `promocoes`
--
ALTER TABLE `promocoes`
  ADD CONSTRAINT `fk_promocoes_produtos1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `tarefas_tipo_usuario`
--
ALTER TABLE `tarefas_tipo_usuario`
  ADD CONSTRAINT `fk_tarefas_1` FOREIGN KEY (`id_tarefa`) REFERENCES `tarefas` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tipo_usuario_1` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipos_usuario` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `tintas`
--
ALTER TABLE `tintas`
  ADD CONSTRAINT `fk_tintas_categorias_tinta1` FOREIGN KEY (`id_categoria_tinta`) REFERENCES `categorias_tinta` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tintas_montadoras1` FOREIGN KEY (`sigla_montadora`) REFERENCES `montadoras` (`sigla`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tintas_tipos_tinta1` FOREIGN KEY (`id_tipo_tinta`) REFERENCES `tipos_tinta` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tintas_unidades1` FOREIGN KEY (`sigla_unidade`) REFERENCES `unidades` (`sigla`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_pessoas1` FOREIGN KEY (`doc_principal_funcionario`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuarios_tipos_usuario1` FOREIGN KEY (`tipo`) REFERENCES `tipos_usuario` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `fk_vendas_pessoas1` FOREIGN KEY (`doc_principal_cliente`) REFERENCES `pessoas` (`doc_principal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_vendas_usuarios1` FOREIGN KEY (`nome_usuario`) REFERENCES `usuarios` (`nome`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
