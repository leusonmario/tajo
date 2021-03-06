/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tajo.master.event;

import org.apache.tajo.ExecutionBlockId;
import org.apache.tajo.storage.fragment.FileFragment;

import java.util.Collection;

public class FragmentScheduleEvent extends TaskSchedulerEvent {
  private final FileFragment leftFragment;
  private final Collection<FileFragment> rightFragments;

  public FragmentScheduleEvent(final EventType eventType, final ExecutionBlockId blockId,
                               final FileFragment fragment) {
    this(eventType, blockId, fragment, null);
  }

  public FragmentScheduleEvent(final EventType eventType,
                               final ExecutionBlockId blockId,
                               final FileFragment leftFragment,
                               final Collection<FileFragment> rightFragments) {
    super(eventType, blockId);
    this.leftFragment = leftFragment;
    this.rightFragments = rightFragments;
  }

  public boolean hasRightFragments() {
    return this.rightFragments != null && !this.rightFragments.isEmpty();
  }

  public FileFragment getLeftFragment() {
    return leftFragment;
  }

  public Collection<FileFragment> getRightFragments() { return rightFragments; }

  @Override
  public String toString() {
    return "FragmentScheduleEvent{" +
        "leftFragment=" + leftFragment +
        ", rightFragments=" + rightFragments +
        '}';
  }
}
