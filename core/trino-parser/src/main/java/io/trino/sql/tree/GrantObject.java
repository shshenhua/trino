/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.sql.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class GrantObject
        extends Node
{
    private final Optional<String> entityKind;
    private final QualifiedName name;
    private final Optional<Identifier> branch;

    public GrantObject(NodeLocation location, Optional<String> entityKind, QualifiedName name, Optional<Identifier> branch)
    {
        super(location);
        this.entityKind = requireNonNull(entityKind, "entityKind is null");
        this.name = requireNonNull(name, "name is null");
        this.branch = requireNonNull(branch, "branch is null");
    }

    public Optional<String> getEntityKind()
    {
        return entityKind;
    }

    public QualifiedName getName()
    {
        return name;
    }

    public Optional<Identifier> getBranch()
    {
        return branch;
    }

    @Override
    public List<? extends Node> getChildren()
    {
        return ImmutableList.of();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GrantObject that = (GrantObject) o;
        return Objects.equals(entityKind, that.entityKind) &&
                Objects.equals(name, that.name) &&
                Objects.equals(branch, that.branch);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("entityKind", entityKind)
                .add("qualifiedName", name)
                .add("branch", branch)
                .toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(entityKind, name, branch);
    }
}
