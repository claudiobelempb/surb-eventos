package br.com.surb.surbeventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_block")
public class Block implements Serializable {

    @Serial
    private static final long serialVersionUID = -4872534519821726949L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endAt;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Block() {
    }

    public Block(Long blockId, Instant startAt, Instant endAt) {
        this.blockId = blockId;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Instant getStartAt() {
        return startAt;
    }

    public void setStartAt(Instant startAt) {
        this.startAt = startAt;
    }

    public Instant getEndAt() {
        return endAt;
    }

    public void setEndAt(Instant endAt) {
        this.endAt = endAt;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Block block = (Block) object;
        return Objects.equals(blockId, block.blockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockId);
    }
}
