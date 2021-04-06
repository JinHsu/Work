/**
 * Copyright 2009-2021 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.sharit.test.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtils {

    private static volatile SqlSessionFactory INSTANCE;

    private SqlSessionFactoryUtils() {
    }

    public static SqlSessionFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (SqlSessionFactoryUtils.class) {
                if (INSTANCE == null) {
                    InputStream is = SqlSessionFactoryUtils.class.getResourceAsStream("/MyBatis-config.xml");
                    INSTANCE = new SqlSessionFactoryBuilder().build(is);
                }
            }
        }
        return INSTANCE;
    }

}
