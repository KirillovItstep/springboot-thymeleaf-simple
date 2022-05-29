package org.itstep.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //Обязательно добавить, иначе при запросе POST не обрабатывает объекты
@AllArgsConstructor
public class MyColor {
    private String name;
}
