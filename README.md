# Kafka
Cheatsheet for all kafka configuration from application.properties - https://gist.github.com/geunho/77f3f9a112ea327457353aa407328771
If any property is missing try putting it under spring.kafka.consumer.properties.* OR spring.kafka.producer.properties.*
If not able to delete the topic and getting error like "Error while renaming dir for Topic" -> delete the version2 folder from zookeper log folder + delete all the logs and restart zookeeper.
