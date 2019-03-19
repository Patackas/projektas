package com.group3.dms.Repository;

import com.group3.dms.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findById(int id);

}
