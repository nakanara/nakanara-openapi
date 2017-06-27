package com.nakanara.openapi.service;


import com.nakanara.openapi.apt.dao.TcCodeDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by steg on 2017-06-27.
 */
@Service("openApiAptService")
public class OpenApiAptService extends HibernateDaoSupport {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory = null;

    /**
     * 지역 코드 조회
     * @return
     */
    public List<TcCodeDao> getLocationCode() {

        List<TcCodeDao> list = (List<TcCodeDao>)getHibernateTemplate().find("from TcCodeDao where code_type = ?", "LAWD");

        return list;

    }
}
