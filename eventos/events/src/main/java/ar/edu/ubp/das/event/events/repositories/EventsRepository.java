package ar.edu.ubp.das.event.events.repositories;

import java.beans.EventSetDescriptor;
import java.util.List;
import java.util.Map;
import java.sql.Types;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ubp.das.event.events.beans.ActivityBean;
import ar.edu.ubp.das.event.events.beans.EventAssistant;

// import com.fasterxml.jackson.databind.BeanProperty;

import ar.edu.ubp.das.event.events.beans.EventsBean;

@Repository
public class EventsRepository {
	@Autowired
	private JdbcTemplate jdbcTpl;
	@Autowired
	private NamedParameterJdbcTemplate namedParamJdbcTpl;

	@SuppressWarnings("unchecked")
	public List<EventsBean> getEvents() {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
				.withProcedureName("get_eventos")
				.withSchemaName("dbo")
				.returningResultSet("events", BeanPropertyRowMapper.newInstance(EventsBean.class));

		Map<String, Object> out = jdbcCall.execute();
		return (List<EventsBean>) out.get("events");
	}

	@SuppressWarnings("unchecked")
	public List<EventsBean> getEvent(int nroEvento) {
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("nro_evento", nroEvento);

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
				.withProcedureName("get_datos_evento")
				.withSchemaName("dbo")
				.returningResultSet("event", BeanPropertyRowMapper.newInstance(EventsBean.class));

		Map<String, Object> out = jdbcCall.execute(in);
		return (List<EventsBean>) out.get("event");
	}

    @SuppressWarnings("unchecked")
    public List<ActivityBean> getActivities(Integer nroEvento) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("nro_evento", nroEvento);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                .withProcedureName("get_actividades_evento")
                .withSchemaName("dbo")
                .returningResultSet("activities", BeanPropertyRowMapper.newInstance(ActivityBean.class));

        Map<String, Object> out = jdbcCall.execute(in);
        return (List<ActivityBean>) out.get("activities");
    }

	@SuppressWarnings("unchecked")
	@Transactional
    public String insAssitant(EventAssistant eventAssistant) {
		// agregar los valores que recibe el procedure
		System.out.println("Entrada 1");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("nro_evento", eventAssistant.getNroEvento())
                .addValue("apellido", eventAssistant.getApellido())
                .addValue("nombre", eventAssistant.getNombre())
				.addValue("actividades" , eventAssistant.getActividades())
                .addValue("correo", eventAssistant.getCorreo())
				.addValue("id_asistente", null, Types.VARCHAR);

		System.out.println("Entrada 2");
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
                .withProcedureName("ins_asistente_evento")
                .withSchemaName("dbo");
		System.out.println("Entrada 3");
        Map<String, Object> out = jdbcCall.execute(in);
		System.out.println("Entrada 4");
        return (String)out.get("id_asistente").toString();
    }

}
