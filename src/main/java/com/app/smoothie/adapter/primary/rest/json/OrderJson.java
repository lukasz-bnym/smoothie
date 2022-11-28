package com.app.smoothie.adapter.primary.rest.json;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderJson
{
    @NotEmpty
    private List<ItemJson> items;
}
