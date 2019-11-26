import {PolymerElement,html} from '@polymer/polymer';
import '@polymer/paper-input/paper-input.js';

class LabCalendarTemplate extends PolymerElement {

    static get template() {
        return html`
            <div>
                <iframe src="https://calendar.google.com/calendar/embed?src=vjqiss4v2deaig60dqgbe053qk%40group.calendar.google.com&ctz=Europe%2FWarsaw" style="border: 0" width="800" height="600" frameborder="0" scrolling="no"></iframe>
            </div>`;
    }

    static get is() {
        return "lab-calendar";
    }
}

customElements.define(LabCalendarTemplate.is, LabCalendarTemplate);