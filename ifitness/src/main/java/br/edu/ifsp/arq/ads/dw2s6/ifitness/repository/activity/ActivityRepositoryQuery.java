package br.edu.ifsp.arq.ads.dw2s6.ifitness.repository.activity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.ads.dw2s6.ifitness.domain.model.Activity;
import br.edu.ifsp.arq.ads.dw2s6.ifitness.repository.filter.ActivityFilter;

public interface ActivityRepositoryQuery {

	Page<Activity> filter(ActivityFilter activityFilter, Pageable pageable);

}
