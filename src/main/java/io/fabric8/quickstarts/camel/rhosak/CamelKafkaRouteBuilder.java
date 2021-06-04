/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.quickstarts.camel.rhosak;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.INFO;

@Component
public class CamelKafkaRouteBuilder extends RouteBuilder {

	@Autowired
	@Qualifier("kafkaConsumerEndpoint")
	private KafkaEndpoint kafkaConsumerEndpoint;

	@Autowired
	@Qualifier("kafkaProducerEndpoint")
	private KafkaEndpoint kafkaProducerEndpoint;

    @Override
    public void configure() throws Exception {


			from(kafkaConsumerEndpoint)
                .id("kafka-consumer")
                .log(INFO,"${body}");


			from("timer://foo?fixedRate=true&period=5000")
                .id("kafka-producer")
			    .setBody(constant("Greetings at fixed rate"))
			    .to(kafkaProducerEndpoint);
    }
}
