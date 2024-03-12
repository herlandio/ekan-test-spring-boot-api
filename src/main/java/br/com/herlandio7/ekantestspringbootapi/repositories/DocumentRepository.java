package br.com.herlandio7.ekantestspringbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.herlandio7.ekantestspringbootapi.models.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}