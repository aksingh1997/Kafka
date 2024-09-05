package com.abhi.KafkaProducer.config;

import com.abhi.KafkaProducer.constants.AppConstants;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PartitionConfig implements Partitioner {

    // If we have 4 partitions, we should return value between range [0-3] from this method
    @Override
    public int partition(String topic, Object key, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        // here we are expecting key to be Pune or Mumbai
        int val = AppConstants.valueOf((String)key).getCode();
        return (val % (cluster.partitionCountForTopic(topic)));
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
