# Kafka
* Cheatsheet for all kafka configuration from application.properties - https://gist.github.com/geunho/77f3f9a112ea327457353aa407328771
* If any property is missing try putting it under spring.kafka.consumer.properties.* OR spring.kafka.producer.properties.*
* If not able to delete the topic and getting error like "Error while renaming dir for Topic" -> delete the version2 folder from zookeper log folder + delete all the logs and restart zookeeper.
### Command to delete the the topic manually
> bin\windows\kakfa-topics.bat --delete --topic TopicName --bootstrap-server localhost:9092
* For sending any messages we first of all need a KafkaTemplate autowired in service layer, this needs to be initialized.
  - There are two ways to initialize it-
    1. hello
