CREATE DATABASE IF NOT EXISTS pixxaria;
USE pixxaria;

-- Criar a tabela de usuários primeiro
CREATE TABLE IF NOT EXISTS `users` (
                                       `id` int NOT NULL AUTO_INCREMENT,
                                       `email` varchar(255) DEFAULT NULL,
                                       `login` varchar(255) DEFAULT NULL,
                                       `nome` varchar(255) DEFAULT NULL,
                                       `password` varchar(255) DEFAULT NULL,
                                       `role` enum('CLIENTE','DONO','FUNCIONARIO') DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Criar a tabela de pizzas
CREATE TABLE IF NOT EXISTS `pizza` (
                                       `id` int NOT NULL AUTO_INCREMENT,
                                       `descricao` varchar(255) DEFAULT NULL,
                                       `disponivel` bit(1) NOT NULL,
                                       `nome` varchar(255) DEFAULT NULL,
                                       `preco` double DEFAULT NULL,
                                       `tamanho` enum('GRANDE','MEDIA','PEQUENA') DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Criar a tabela de preços de pizza
CREATE TABLE IF NOT EXISTS `pizza_preco` (
                                             `id` int NOT NULL AUTO_INCREMENT,
                                             `data_fim` date DEFAULT NULL,
                                             `data_inicio` date DEFAULT NULL,
                                             `nome` varchar(255) DEFAULT NULL,
                                             `preco` double DEFAULT NULL,
                                             `pizza_id` int DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             KEY `FK72ghsjqeaanc7j2e74jf5dgmb` (`pizza_id`),
                                             CONSTRAINT `FK72ghsjqeaanc7j2e74jf5dgmb` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Criar a tabela de pedidos
CREATE TABLE IF NOT EXISTS `pedido` (
                                        `id` int NOT NULL AUTO_INCREMENT,
                                        `data_criacao` datetime(6) DEFAULT NULL,
                                        `status` enum('ENTREGANDO','ENTREGUE','PENDENTE','PREPARANDO') DEFAULT NULL,
                                        `valor_total` double DEFAULT NULL,
                                        `user_id` int NOT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `FKpgju9njy4a3soyqe1f8r19jia` (`user_id`),
                                        CONSTRAINT `FKpgju9njy4a3soyqe1f8r19jia` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Criar a tabela de itens do pedido
CREATE TABLE IF NOT EXISTS `pedido_item` (
                                             `id` int NOT NULL AUTO_INCREMENT,
                                             `quantidade` int DEFAULT NULL,
                                             `pedido_id` int DEFAULT NULL,
                                             `pizza_preco_id` int NOT NULL,
                                             PRIMARY KEY (`id`),
                                             KEY `FKeyouxfvoi291lpo5168e6wpej` (`pedido_id`),
                                             KEY `FKnmmbby6c87f6ayklwnggbdug7` (`pizza_preco_id`),
                                             CONSTRAINT `FKeyouxfvoi291lpo5168e6wpej` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
                                             CONSTRAINT `FKnmmbby6c87f6ayklwnggbdug7` FOREIGN KEY (`pizza_preco_id`) REFERENCES `pizza_preco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
