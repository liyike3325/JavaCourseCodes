# kafka 3节点集群，测试功能和性能  

## 测试功能  
创建主题  
bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic test32 --partitions 3 --replication-factor 2  
生产者发送消息  
bin/kafka-console-producer.sh --bootstrap-server localhost:9093 --topic test32  
消费者消费消息  
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test32 --from-beginning  

## 测试性能  
生产者测试性能    
bin/kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1000 --throughput 200000 --producer-props bootstrap.servers=localhost:9094  
消息数每秒16455  

消费者测试性能  
bin/kafka-consumer-perf-test.sh --bootstrap-server localhost:9092 --topic test32 --fetch-size 1048576 --messages 100000 --threads 1  
消息数每秒127879  