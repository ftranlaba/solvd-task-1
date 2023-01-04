package sql.dao.entity.state;


import sql.dao.MysqlDao;
import sql.dao.MysqlType;
import sql.datamodels.entity.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StateDaoMysql extends MysqlDao implements IStateDao {

    @Override
    public Optional get(int id) {
        //public State(String name)
        String sql = "SELECT name FROM states WHERE id_state = ?";
        return Optional.ofNullable(new State(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public State(String name)
        String sql = "SELECT name FROM states";
        List<Object[]> list = getWithTryCatch(sql);
        List<State> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new State(o));
        }
        return output;
    }

    @Override
    public void save(State o) {
        String sql = "INSERT INTO states(name) VALUES (?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(State o, int id) {
        String sql = "UPDATE states SET name = ? WHERE id_state = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(id);

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM states WHERE id_state = ?";
        deleteWithTryCatch(sql, id);
    }
}
