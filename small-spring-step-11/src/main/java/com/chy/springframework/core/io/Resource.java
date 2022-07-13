package com.chy.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: com.chy
 * @Date: 2022/5/7 10:44
 * @Description:
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
