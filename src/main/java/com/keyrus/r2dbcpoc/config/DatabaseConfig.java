package com.keyrus.r2dbcpoc.config;

import com.keyrus.r2dbcpoc.converters.BookReadConverter;
import com.keyrus.r2dbcpoc.converters.PersonReadConverter;
import com.keyrus.r2dbcpoc.converters.PersonWriteConverter;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.util.ArrayList;
import java.util.List;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class DatabaseConfig extends AbstractR2dbcConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, "postgresql")
                        .option(HOST, "localhost")
                        .option(PORT, 5432)
                        .option(USER, "olfa")
                        .option(PASSWORD, "admin")
                        .option(DATABASE, "library")
                        .option(MAX_SIZE, 40)
                        .build());
    }

    @Override
    protected List<Object> getCustomConverters() {
        List<Object> converterList = new ArrayList<>();
        converterList.add(new PersonReadConverter());
        converterList.add(new PersonWriteConverter());
        converterList.add(new BookReadConverter());
        return converterList;
    }
}
