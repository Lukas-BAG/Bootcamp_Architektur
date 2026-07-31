/* ══════════════════════════════════════════════════════════════
   quiz.js — geteilte Übungs-Engine für alle Lehrkurs-Seiten.
   Enthält 5 unabhängige Komponenten, die per CSS-Klasse/Attribut
   aktiviert werden. Kein Framework, keine Build-Schritte nötig —
   einfach <script src="../js/quiz.js"></script> einbinden.

   ── Markup-Verträge ──

   1) Multiple/Single Choice
   <div class="quiz" data-quiz-type="mc" oder "sc">
     <p class="quiz__question">Frage…</p>
     <ul class="quiz__options">
       <li class="quiz__option" data-correct>Richtige Antwort</li>
       <li class="quiz__option">Falsche Antwort</li>
     </ul>
     <button class="quiz__check">Prüfen</button>
     <button class="quiz__reset" type="button">Zurücksetzen</button>
     <div class="quiz__feedback"></div>
   </div>
   "sc" erlaubt nur eine Auswahl, "mc" mehrere.

   2) Lückentext
   <div class="cloze">
     <p class="cloze__text">Text mit <input class="cloze__blank"
       data-answer="Antwort|Alternative" size="10"> Lücke.</p>
     <div class="cloze__actions">
       <button class="cloze__check">Prüfen</button>
       <button class="quiz__reset" type="button">Zurücksetzen</button>
     </div>
     <div class="quiz__feedback"></div>
   </div>
   Mehrere gültige Antworten mit "|" trennen. Vergleich ist
   groß-/kleinschreibungs- und leerzeichen-tolerant.

   3) Drag & Drop
   <div class="dragdrop">
     <div class="dragdrop__layout">
       <div class="dragdrop__pool">
         <div class="dragdrop__item" data-match="ziel-a">Baustein</div>
       </div>
       <div class="dragdrop__targets">
         <div class="dragdrop__target" data-target="ziel-a">
           <span class="dragdrop__target-label">Ziel A</span>
           <div class="dragdrop__slot"></div>
         </div>
       </div>
       <div class="dragdrop__actions">
         <button class="dragdrop__check">Prüfen</button>
         <button class="quiz__reset" type="button">Zurücksetzen</button>
         <div class="quiz__feedback"></div>
       </div>
     </div>
   </div>
   Funktioniert per echtem Drag (Maus) UND per Klicken
   (erst Baustein anklicken, dann Ziel anklicken) — Touch-tauglich.

   4) Flip-Karten (card3d) — Klick dreht die Karte, kein Markup
   außer der bestehenden .card3d/.card3d__inner Struktur nötig.

   5) Aufklapp-Kontrollfragen (<details class="reveal">) — nativ,
   keine JS-Anbindung nötig.
   ══════════════════════════════════════════════════════════════ */

(function () {
  "use strict";

  function norm(s) {
    return (s || "").trim().toLowerCase().replace(/\s+/g, " ");
  }

  /* ── 1) Multiple / Single Choice ── */
  function initChoiceQuizzes() {
    document.querySelectorAll(".quiz[data-quiz-type]").forEach(function (quiz) {
      var type = quiz.getAttribute("data-quiz-type");
      var options = Array.prototype.slice.call(quiz.querySelectorAll(".quiz__option"));
      var checkBtn = quiz.querySelector(".quiz__check");
      var resetBtn = quiz.querySelector(".quiz__reset");
      var feedback = quiz.querySelector(".quiz__feedback");

      options.forEach(function (opt) {
        opt.addEventListener("click", function () {
          if (quiz.classList.contains("is-checked")) return;
          if (type === "sc") {
            options.forEach(function (o) { o.classList.remove("is-selected"); });
            opt.classList.add("is-selected");
          } else {
            opt.classList.toggle("is-selected");
          }
        });
      });

      if (checkBtn) checkBtn.addEventListener("click", function () {
        var allCorrect = true;
        options.forEach(function (opt) {
          var isCorrect = opt.hasAttribute("data-correct");
          var isSelected = opt.classList.contains("is-selected");
          if (isCorrect) opt.classList.add("is-correct-answer");
          if (isSelected && !isCorrect) opt.classList.add("is-wrong-selected");
          if (isCorrect !== isSelected) allCorrect = false;
        });
        quiz.classList.add("is-checked");
        if (feedback) {
          feedback.textContent = allCorrect ? "Richtig!" : "Noch nicht ganz — sieh dir die Markierungen an.";
          feedback.classList.toggle("is-ok", allCorrect);
          feedback.classList.toggle("is-fail", !allCorrect);
        }
      });

      if (resetBtn) resetBtn.addEventListener("click", function () {
        quiz.classList.remove("is-checked");
        options.forEach(function (opt) {
          opt.classList.remove("is-selected", "is-correct-answer", "is-wrong-selected");
        });
        if (feedback) { feedback.textContent = ""; feedback.classList.remove("is-ok", "is-fail"); }
      });
    });
  }

  /* ── 2) Lückentext ── */
  function initCloze() {
    document.querySelectorAll(".cloze").forEach(function (cloze) {
      var blanks = Array.prototype.slice.call(cloze.querySelectorAll(".cloze__blank"));
      var checkBtn = cloze.querySelector(".cloze__check");
      var resetBtn = cloze.querySelector(".quiz__reset");
      var feedback = cloze.querySelector(".quiz__feedback");

      if (checkBtn) checkBtn.addEventListener("click", function () {
        var correctCount = 0;
        blanks.forEach(function (input) {
          var answers = (input.getAttribute("data-answer") || "").split("|").map(norm);
          var ok = answers.indexOf(norm(input.value)) !== -1;
          input.classList.toggle("is-correct", ok);
          input.classList.toggle("is-wrong", !ok);
          if (ok) correctCount++;
        });
        if (feedback) {
          var all = correctCount === blanks.length;
          feedback.textContent = correctCount + " von " + blanks.length + " Lücken richtig.";
          feedback.classList.toggle("is-ok", all);
          feedback.classList.toggle("is-fail", !all);
        }
      });

      if (resetBtn) resetBtn.addEventListener("click", function () {
        blanks.forEach(function (input) {
          input.value = ""; input.classList.remove("is-correct", "is-wrong");
        });
        if (feedback) { feedback.textContent = ""; feedback.classList.remove("is-ok", "is-fail"); }
      });
    });
  }

  /* ── 3) Drag & Drop ── */
  function initDragDrop() {
    document.querySelectorAll(".dragdrop").forEach(function (dd) {
      var pool = dd.querySelector(".dragdrop__pool");
      var items = Array.prototype.slice.call(dd.querySelectorAll(".dragdrop__item"));
      var slots = Array.prototype.slice.call(dd.querySelectorAll(".dragdrop__slot"));
      var checkBtn = dd.querySelector(".dragdrop__check");
      var resetBtn = dd.querySelector(".quiz__reset");
      var feedback = dd.querySelector(".quiz__feedback");
      var picked = null;

      function placeInSlot(item, slot) {
        var existing = slot.querySelector(".dragdrop__item");
        if (existing) pool.appendChild(existing);
        slot.appendChild(item);
      }

      items.forEach(function (item, i) {
        item.setAttribute("draggable", "true");
        if (!item.id) item.id = "dd-item-" + Math.random().toString(36).slice(2) + i;

        item.addEventListener("dragstart", function (e) {
          e.dataTransfer.setData("text/plain", item.id);
          item.classList.add("is-dragging");
        });
        item.addEventListener("dragend", function () { item.classList.remove("is-dragging"); });

        /* Klick-Fallback für Touch/Barrierefreiheit */
        item.addEventListener("click", function () {
          if (dd.classList.contains("is-checked")) return;
          items.forEach(function (o) { o.classList.remove("is-picked"); });
          picked = item;
          item.classList.add("is-picked");
        });
      });

      slots.forEach(function (slot) {
        slot.addEventListener("dragover", function (e) { e.preventDefault(); slot.classList.add("is-over"); });
        slot.addEventListener("dragleave", function () { slot.classList.remove("is-over"); });
        slot.addEventListener("drop", function (e) {
          e.preventDefault(); slot.classList.remove("is-over");
          var id = e.dataTransfer.getData("text/plain");
          var item = document.getElementById(id);
          if (item) placeInSlot(item, slot);
        });
        slot.addEventListener("click", function () {
          if (dd.classList.contains("is-checked") || !picked) return;
          placeInSlot(picked, slot);
          picked.classList.remove("is-picked");
          picked = null;
        });
      });

      if (checkBtn) checkBtn.addEventListener("click", function () {
        var allCorrect = true;
        dd.querySelectorAll(".dragdrop__target").forEach(function (target) {
          var slot = target.querySelector(".dragdrop__slot");
          var item = slot.querySelector(".dragdrop__item");
          var ok = !!item && item.getAttribute("data-match") === target.getAttribute("data-target");
          target.classList.toggle("is-correct", ok);
          target.classList.toggle("is-wrong", !ok);
          if (!ok) allCorrect = false;
        });
        dd.classList.add("is-checked");
        if (feedback) {
          feedback.textContent = allCorrect ? "Alle Zuordnungen stimmen!" : "Noch nicht alles richtig zugeordnet.";
          feedback.classList.toggle("is-ok", allCorrect);
          feedback.classList.toggle("is-fail", !allCorrect);
        }
      });

      if (resetBtn) resetBtn.addEventListener("click", function () {
        dd.classList.remove("is-checked");
        dd.querySelectorAll(".dragdrop__target").forEach(function (t) { t.classList.remove("is-correct", "is-wrong"); });
        items.forEach(function (item) { pool.appendChild(item); item.classList.remove("is-picked"); });
        picked = null;
        if (feedback) { feedback.textContent = ""; feedback.classList.remove("is-ok", "is-fail"); }
      });
    });
  }

  /* ── 4) Flip-Karten ── */
  function initFlipCards() {
    document.querySelectorAll(".card3d").forEach(function (card) {
      card.addEventListener("click", function () { card.classList.toggle("is-flipped"); });
    });
  }

  document.addEventListener("DOMContentLoaded", function () {
    initChoiceQuizzes();
    initCloze();
    initDragDrop();
    initFlipCards();
  });
})();
