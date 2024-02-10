        Dois microservices que se comunicam usando o RabbitMQ. O serviço de usuário cadastra novos usuários e utiliza uma fila na CloudAMQP para se comunicar com o microservice de e-mail. 
Após o cadastro, o serviço de e-mail envia uma mensagem de boas-vindas para o e-mail do usuário cadastrado. Essa comunicação assíncrona é eficiente e permite que ambos os microservices
operem de forma independente
