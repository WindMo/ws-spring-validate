package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import ws.spring.validate.group.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WindShadow
 * @version 2022-10-12.
 */
@Slf4j
@GroupSequenceProvider(Pot.PotGroup.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pot {

    private Integer code;

    /**
     * {@link DefaultGroupSequenceProvider}方式提供默认的校验组，指定group时，命中组才会被校验，不命中不校验
     */
    @NotBlank(groups = Group.Query.class)
    @Null(groups = Group.Insert.class)
    private String id;

    /**
     * {@link DefaultGroupSequenceProvider}方式提供默认的校验组，不指定group时，不管命中哪个组都会被校验
     */
    @NotBlank
    private String color;

    @Range(min = 10L, max = 100L, groups = Group.Update.class)
    private Integer diameter;


    /**
     * {@link DefaultGroupSequenceProvider}方式提供默认的校验组，
     * {@link #getValidationGroups}返回值必须包含目标类{@link Pot},
     *
     */
    public static class PotGroup implements DefaultGroupSequenceProvider<Pot> {

        public PotGroup() {

            // 只调用一次
            log.info("Call PotGroup::Construct");
        }

        @Override
        public List<Class<?>> getValidationGroups(Pot pot) {

            List<Class<?>> groups = new ArrayList<>();
            groups.add(Pot.class);
            if (pot != null) {

                Integer code = pot.getCode();
                if (code != null) {

                    switch (code) {

                        case 0:
                            groups.add(Group.Insert.class);
                            break;
                        case 1:
                            groups.add(Group.Query.class);
                            break;
                        default:
                            groups.add(Group.Update.class);
                    }
                }
            }
            log.info("PotGroup :: groups: {}", groups.stream().map(Class::getSimpleName).collect(Collectors.joining(",")));
            return groups;
        }
    }
}
