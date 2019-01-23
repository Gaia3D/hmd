package hmd.persistence.postgresql;

import org.springframework.stereotype.Repository;

import hmd.domain.Layer;

@Repository
public interface LayerMapper {
	
	Long getLayerTotalCount(Layer layer);

	int insertLayer(Layer layer);
}
