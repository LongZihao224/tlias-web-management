package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptLog {
    /**
     * id	int
     * create_time	datetime
     * description	varchar
     */
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
