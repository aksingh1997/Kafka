# Kafka
* Cheatsheet for all kafka configuration from application.properties - https://gist.github.com/geunho/77f3f9a112ea327457353aa407328771
* If any property is missing try putting it under spring.kafka.consumer.properties.* OR spring.kafka.producer.properties.*
* If not able to delete the topic and getting error like "Error while renaming dir for Topic" -> delete the version2 folder from zookeper log folder + delete all the logs and restart zookeeper.
#### Command to delete the the topic manually
> bin\windows\kakfa-topics.bat --delete --topic TopicName --bootstrap-server localhost:9092

## Kafka Producer settings - 
* For sending any messages we first of all need a KafkaTemplate autowired in service layer, this needs to be initialized. There are two ways to initialize it-
    1. Making a configuration class and returning a bean of kafka template. This requires use of Map and passing it as param to KafkaTemplate constructor.
    2. Second approach and better approach involves using application.properties to initialize KafkaTemplate.
* If we are not bothered about partitions yet, we can simply send our messages using following code. This will simply send the data to given topic and will create default number of partitions on its own.
  > kafkaTemplate.send(topic, data);
* However if we want control till the partition level, we should be creating topics ahead to avoid errors. Create topic using class - NewTopic, provide the necessary details like Topic name, partition count, replication count, etc. and set is as @Bean. This will create topic during startup.
* Also we might be interested in sending messages to particular partition only. How it works is we need to provide  a key, that key is hashed to range of (0 - n-1)
if we have n partitions. Here we need to provide hashing algorithm. To do so, one need to implement Partioner class and override the partition method.
See in code

    ``` java
    @Override
    public int partition(String topic, Object key, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        int val = AppConstants.valueOf((String)key).getCode(); // Our hashing algo, could be anything. The key is same which we passed during kafkaTemplate.send()
        return (val % (cluster.partitionCountForTopic(topic))); // doing modulo after hashing with partition count
    }
    ```
* Provide the details of this config class that implements Partitioner in application.properties.
* Now sending messages using KafkaTemplate looks like
  > kafkaTemplate.send(topic, key, data);
